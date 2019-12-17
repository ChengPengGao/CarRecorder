package com.cf.carrecorder.ui.foorprint;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.bumptech.glide.Glide;
import com.cf.carrecorder.R;
import com.cf.carrecorder.adapter.grid.GirdAdapter;
import com.cf.carrecorder.adapter.grid.InfoWinAdapter;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.bean.RecordListData;
import com.cf.carrecorder.config.GlobalConfig;
import com.cf.carrecorder.event.CarRecorderEvent;
import com.cf.carrecorder.ui.bind.DeviceBindFragment;
import com.cf.carrecorder.ui.login.LoginFragment;
import com.cf.carrecorder.ui.mine.MineFragment;
import com.cf.carrecorder.ui.report.ReportFragment;
import com.cf.carrecorder.ui.showinfo.ShowInfoFragment;
import com.cf.carrecorder.utils.FragmentSwitcher;
import com.cf.carrecorder.utils.SpacesItemDecoration;
import com.cf.carrecorder.utils.ToastUtil;
import com.cf.carrecorder.utils.TypeSafer;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

import static com.amap.api.maps.model.MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER;

/**
 * @author chenxihu
 * @date 2019-11-18
 * @email androidhcx@163.com
 **/
public class FootPrintFragment extends BaseFragment<FootPrintView, FootPrintPresenter> implements FootPrintView, AMap.OnMarkerClickListener {

    private static FootPrintFragment instance;
    private AMap aMap;
    private Marker mStartMarker;
    private Marker mEndMarker;
    private UiSettings uiSettings;
    private View infoWindow = null;
    private AppCompatImageView iv_info;
    private InfoWinAdapter adapter;
    /**
     * 未绑定的布局
     */
    @BindView(R.id.ll_unBind)
    LinearLayout llUnBind;
    @BindView(R.id.ll_bind)
    LinearLayout llBind;
    @BindView(R.id.map_view)
    MapView mMapView;

    /**
     * 网格布局
     */
    @BindView(R.id.rv_grid)
    RecyclerView rvGrid;

    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.ll_add)
    LinearLayout llAdd;

    @BindView(R.id.tv_selected)
    TextView tvSelected;

    @BindView(R.id.tv_selectCount)
    TextView tvSelectCount;

    @BindView(R.id.rg_footprint)
    RadioGroup radioGroup;

    @BindView(R.id.ll_select)
    LinearLayout llSelect;

    GirdAdapter gridAdapter;

    List<RecordListData.RowsBean> gridBeans;

    public static FootPrintFragment getInstance() {
        if (instance == null) {
            instance = new FootPrintFragment();
        }

        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView( inflater, container, savedInstanceState );
        mMapView.onCreate( savedInstanceState );
        aMap = mMapView.getMap();
        initMapView();
        return view;
    }

    @Override
    public void onEventMainThread(CarRecorderEvent event) {
        super.onEventMainThread( event );

        switch (event.getType()) {
            case CarRecorderEvent.BIND:
                showBindLayout();


                gridBeans = new ArrayList<>();
                gridAdapter = new GirdAdapter( gridBeans, getActivity() );
                rvGrid.setAdapter( gridAdapter );
                rvGrid.setLayoutManager( new GridLayoutManager( getActivity(), 4 ) );
                rvGrid.addItemDecoration( new SpacesItemDecoration( 3 ) );
                presenter.loadGridData();
                break;
            case CarRecorderEvent.SELECT:
                TypeSafer.text( tvSelectCount, "已选择" + gridAdapter.getSelectedData().size() + "张" );
                break;
            default:
                break;
        }
    }

    @Override
    protected void initView(View view) {
        if (GlobalConfig.isBinded) {
            showBindLayout();
            showBottomBar();

            gridBeans = new ArrayList<>();
            gridAdapter = new GirdAdapter( gridBeans, getActivity() );
            rvGrid.setAdapter( gridAdapter );
            rvGrid.setLayoutManager( new GridLayoutManager( getActivity(), 4 ) );
            rvGrid.addItemDecoration( new SpacesItemDecoration( 1 ) );
            presenter.loadGridData();
        } else {
            showUnBindLayout();
        }


    }

    /**
     * 经纬度的坐标点
     *
     * @param v
     * @param h
     */
    public void drawMaker(double v, double h, String id) {
        LatLng latLng = new LatLng( v, h );
        mStartMarker = aMap.addMarker( new MarkerOptions().icon( BitmapDescriptorFactory.fromView( getBitmapView( getActivity(), id ) ) ) );
        mStartMarker.setPosition( latLng );
    }

    /**
     * 设置图片
     *
     * @param context
     * @param photoUrl
     * @return
     */
    public static View getBitmapView(Context context, String photoUrl) {
        LayoutInflater factory = LayoutInflater.from( context );
        View view = factory.inflate( R.layout.item_map_infowindows, null );
        AppCompatImageView imageView = view.findViewById( R.id.iv_info_window );
        Glide.with( context ).load( photoUrl ).error( R.mipmap.icon_log ).fallback( R.mipmap.icon_log ).into( imageView );
        return view;
    }

    /**
     * 初始化地图的内容
     */
    private void initMapView() {
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.interval( 2000 );
        myLocationStyle.myLocationType( LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER );
        myLocationStyle.strokeColor( Color.TRANSPARENT );
        myLocationStyle.radiusFillColor( Color.TRANSPARENT );
        aMap.setOnMyLocationChangeListener( new AMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                if (location != null) {

                }
            }
        } );
        myLocationStyle.showMyLocation( false );
        aMap.setMyLocationStyle( myLocationStyle );
        aMap.setMyLocationEnabled( true );
        aMap.setMapType( AMap.MAP_TYPE_NORMAL );
        uiSettings = aMap.getUiSettings();
        //缩放按钮
        uiSettings.setZoomControlsEnabled( false );
        uiSettings.setLogoBottomMargin( -200 );
        aMap.setOnMarkerClickListener( this );
        adapter = new InfoWinAdapter( getActivity() );
        adapter.setOnItemButtonClick( new InfoWinAdapter.OnItemButtonClick() {
            @Override
            public boolean onButtonClick(View view) {
                ToastUtil.show( "View" );
                return false;
            }
        } );
        aMap.setInfoWindowAdapter( adapter );
        CameraUpdate mCameraUpdate = CameraUpdateFactory.newCameraPosition( new CameraPosition( new LatLng( 30.244239, 120.184250 ), 18, 30, 0 ) );
        aMap.moveCamera( mCameraUpdate );
        setInfoWindow( gridBeans );
    }

    /**
     * 设置去过的地方
     */
    public void setInfoWindow(List<RecordListData.RowsBean> beans) {
        if (beans != null) {
            drawMaker( 30.244239, 120.184250, "" );
            drawMaker( 30.321842, 120.171429, "" );
            drawMaker( 30.167616, 120.227734, "'" );
        }
    }

    @Override
    protected int initRootView() {
        return R.layout.fragment_footprint;
    }

    @Override
    protected FootPrintPresenter initPresenter() {
        return new FootPrintPresenter();
    }

    @OnClick({
            R.id.btn_bind,
            R.id.tv_mine,
            R.id.iv_add,
            R.id.ll_all,
            R.id.tv_bottom_bind,
            R.id.tv_bottom_report,
            R.id.tv_selected,
            R.id.tv_save,
            R.id.tv_remove,
            R.id.tv_collect})
    protected void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bind:
                if (!GlobalConfig.isLogined) {
                    ToastUtil.show( "请先登录" );
                    return;
                }
                FragmentSwitcher.replaceFragment( DeviceBindFragment.getInstance() );
                break;
            case R.id.tv_mine:
                if (GlobalConfig.isLogined) {
                    FragmentSwitcher.replaceUnAddToBackStackFragment( MineFragment.getInstance() );
                } else {
                    FragmentSwitcher.replaceUnAddToBackStackFragment( LoginFragment.getInstance() );
                }
                break;
            case R.id.iv_add:
                showAddBar();
                break;
            case R.id.ll_all:
                showBottomBar();
                break;
            case R.id.tv_bottom_report:
                if (!GlobalConfig.isLogined) {
                    ToastUtil.show( "请先登录" );
                    return;
                }
                FragmentSwitcher.replaceFragment( ReportFragment.getInstance() );
                break;
            case R.id.tv_bottom_bind:
                if (!GlobalConfig.isLogined) {
                    ToastUtil.show( "请先登录" );
                    return;
                }
                FragmentSwitcher.replaceFragment( DeviceBindFragment.getInstance() );
                break;
            case R.id.tv_selected:

                gridAdapter.changeSelected();
                if (gridAdapter.isSelectMode) {
                    showSelectedMode();
                } else {
                    showGridMode();
                }
                break;
            case R.id.tv_save:
                presenter.saveImg( gridAdapter.getSelectedData() );
                break;
            case R.id.tv_remove:
                presenter.remove( gridAdapter.getSelectedData() );
                break;
            case R.id.tv_collect:
                presenter.collect( gridAdapter.getSelectedData() );
                break;
            default:
                break;
        }
    }

    @Override
    public void showUnBindLayout() {
        llBind.setVisibility( View.GONE );
        llUnBind.setVisibility( View.VISIBLE );
    }

    @Override
    public void showBindLayout() {
        llBind.setVisibility( View.VISIBLE );
        llUnBind.setVisibility( View.GONE );
    }

    @Override
    public void showGrid() {
        tvSelected.setVisibility( View.VISIBLE );
        rvGrid.setVisibility( View.VISIBLE );
        mMapView.setVisibility( View.GONE );
    }

    @Override
    public void showMap() {
        tvSelected.setVisibility( View.GONE );
        rvGrid.setVisibility( View.GONE );
        mMapView.setVisibility( View.VISIBLE );
    }

    @Override
    public void showGridData(List<RecordListData.RowsBean> datas) {

        gridBeans.clear();
        gridBeans.addAll( datas );
        gridAdapter.notifyDataSetChanged();
    }

    @Override
    public void showBottomBar() {
        llBottom.setVisibility( View.VISIBLE );
        llAdd.setVisibility( View.GONE );
    }

    @Override
    public void showAddBar() {
        llBottom.setVisibility( View.GONE );
        llAdd.setVisibility( View.VISIBLE );
    }

    @Override
    public void showSelectedMode() {

        llSelect.setVisibility( View.VISIBLE );
        llAdd.setVisibility( View.GONE );
        llBottom.setVisibility( View.GONE );
        TypeSafer.text( tvSelectCount, "已选择" + gridAdapter.getSelectedData().size() + "张" );
        TypeSafer.text( tvSelected, "返回" );
        radioGroup.setVisibility( View.GONE );
        tvSelectCount.setVisibility( View.VISIBLE );
    }

    @Override
    public void showGridMode() {
        llSelect.setVisibility( View.GONE );
        llAdd.setVisibility( View.GONE );
        llBottom.setVisibility( View.VISIBLE );
        radioGroup.setVisibility( View.VISIBLE );
        tvSelectCount.setVisibility( View.GONE );
        TypeSafer.text( tvSelected, "选择" );
    }

    @Override
    public void removeList(List<Integer> ids) {

        List<RecordListData.RowsBean> removeBeans = new ArrayList<>();
        for(int i = 0 ; i < gridBeans.size();i++){
            if(ids.contains(gridBeans.get(i).getId())){
                removeBeans.add(gridBeans.get(i));
            }

        }
        gridAdapter.changeSelected();
        showGridMode();
        gridBeans.removeAll(removeBeans);
        gridAdapter.notifyDataSetChanged();

    }


    @OnCheckedChanged({R.id.rbtn_map, R.id.rbtn_grid})
    public void onRadioCheck(CompoundButton view, boolean isChecked) {
        switch (view.getId()) {

            case R.id.rbtn_map:
                if (isChecked) {
                    showMap();
                }
                break;
            case R.id.rbtn_grid:
                if (isChecked) {
                    showGrid();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState( outState );
        mMapView.onSaveInstanceState( outState );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        ToastUtil.show( "marker" );
        RecordListData.RowsBean rowsBean = new RecordListData.RowsBean();
        if (gridBeans != null && gridBeans.size() > 0) {
            rowsBean.setPhotoUrl( gridBeans.get( 0 ).getPhotoUrl() );
        }
        rowsBean.setLatitude( marker.getPosition().latitude );
        rowsBean.setLatitude( marker.getPosition().longitude );
        FragmentSwitcher.replaceUnAddToBackStackFragment( ShowInfoFragment.getInstance( rowsBean ) );
        return false;
    }
}
