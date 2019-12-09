package com.cf.carrecorder.ui.foorprint;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

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
import com.cf.carrecorder.R;
import com.cf.carrecorder.adapter.GirdAdapter;
import com.cf.carrecorder.base.fragment.BaseFragment;
import com.cf.carrecorder.bean.GridBean;
import com.cf.carrecorder.config.GlobalConfig;
import com.cf.carrecorder.event.CarRecorderEvent;
import com.cf.carrecorder.ui.bind.DeviceBindFragment;
import com.cf.carrecorder.ui.login.LoginFragment;
import com.cf.carrecorder.ui.mine.MineFragment;
import com.cf.carrecorder.ui.report.ReportFragment;
import com.cf.carrecorder.utils.FragmentSwitcher;
import com.cf.carrecorder.utils.SpacesItemDecoration;
import com.cf.carrecorder.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
public class FootPrintFragment extends BaseFragment<FootPrintView, FootPrintPresenter> implements FootPrintView {

    private static FootPrintFragment instance;
    private AMap aMap;
    private Marker mStartMarker;
    private Marker mEndMarker;
    private UiSettings uiSettings;
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

    GirdAdapter gridAdapter;

    List<GridBean> gridBeans;

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
                gridAdapter = new GirdAdapter( gridBeans );
                rvGrid.setAdapter( gridAdapter );
                rvGrid.setLayoutManager( new GridLayoutManager( getActivity(), 4 ) );
                rvGrid.addItemDecoration( new SpacesItemDecoration( 1 ) );
                presenter.loadGridData();
                break;
            default:
                break;
        }
    }

    @Override
    protected void initView(View view) {
        if (GlobalConfig.isBinded) {
            showBindLayout();

            gridBeans = new ArrayList<>();
            gridAdapter = new GirdAdapter( gridBeans );
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
    public void drawMaker(double v, double h) {
        LatLng latLng = new LatLng( v, h );
        mStartMarker = aMap.addMarker( new MarkerOptions().icon( BitmapDescriptorFactory.fromBitmap( BitmapFactory.decodeResource( getResources(), R.mipmap.start ) ) ) );
        mStartMarker.setPosition( latLng );
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
        drawMaker( 30.244239, 120.184250 );
        CameraUpdate mCameraUpdate = CameraUpdateFactory.newCameraPosition( new CameraPosition( new LatLng( 30.244239, 120.184250 ), 18, 30, 0 ) );
        aMap.moveCamera( mCameraUpdate );
    }

    @Override
    protected int initRootView() {
        return R.layout.fragment_footprint;
    }

    @Override
    protected FootPrintPresenter initPresenter() {
        return new FootPrintPresenter();
    }

    @OnClick({R.id.btn_bind, R.id.tv_mine, R.id.iv_add})
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
                if (!GlobalConfig.isLogined) {
                    ToastUtil.show( "请先登录" );
                    return;
                }
                FragmentSwitcher.replaceFragment( ReportFragment.getInstance() );
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
        rvGrid.setVisibility( View.VISIBLE );
        mMapView.setVisibility( View.GONE );
    }

    @Override
    public void showMap() {
        rvGrid.setVisibility( View.GONE );
        mMapView.setVisibility( View.VISIBLE );
    }

    @Override
    public void showGridData(List<GridBean> datas) {
        gridBeans.clear();
        gridBeans.addAll( datas );
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
}
