package com.example.cuciin_android.activity.modul.about_us;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.cuciin_android.R;
import com.example.cuciin_android.activity.modul.about_us.AboutUsActivity;
import com.example.cuciin_android.activity.modul.nearby.NearbyActivity;
import com.example.cuciin_android.base.BaseFragment;
import com.example.cuciin_android.utils.session.UserSessionRepositoryRepository;
import com.example.cuciin_android.utils.utility.UtilProvider;
import com.google.android.libraries.places.api.Places;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class AboutUsFragment extends BaseFragment<AboutUsActivity, AboutUsContract.Presenter> implements AboutUsContract.View{
    private Context context;
    private ImageView ivAndro;
    private ImageView ivTude;
    private ImageView ivDary;
    private ImageView ivIlham;
    private ImageView ivEkky;
    private ImageView ivRissa;

    public AboutUsFragment(Context context){
        this.context = context;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.about_us, container, false);
        mPresenter = new AboutUsPresenter(this);
        mPresenter.start();

        setDevResource();
        setSponsoredResource();
        setSupportedResource();

        return fragmentView;
    }

    private void setDevResource(){
        //get image
        ivAndro = (ImageView) fragmentView.findViewById(R.id.ivDevAndro);
        ivIlham = (ImageView) fragmentView.findViewById(R.id.ivDevIlham);
        ivTude = (ImageView) fragmentView.findViewById(R.id.ivDevTude);
        ivDary = (ImageView) fragmentView.findViewById(R.id.ivDevDarry);
        ivRissa = (ImageView) fragmentView.findViewById(R.id.ivDevRissa);
        ivEkky = (ImageView) fragmentView.findViewById(R.id.ivDevEkky);

        Bitmap data;
        data = mPresenter.compressImages(getContext(), R.drawable.andro, 120, 120);
        ivAndro.setImageBitmap(data);
        data = mPresenter.compressImages(getContext(), R.drawable.ekky, 120, 120);
        ivEkky.setImageBitmap(data);
        data = mPresenter.compressImages(getContext(), R.drawable.tude, 120, 120);
        ivTude.setImageBitmap(data);
        data = mPresenter.compressImages(getContext(), R.drawable.darry, 120, 120);
        ivDary.setImageBitmap(data);
        data = mPresenter.compressImages(getContext(), R.drawable.rissa, 120, 120);
        ivRissa.setImageBitmap(data);
        data = mPresenter.compressImages(getContext(), R.drawable.ilham, 120, 120);
        ivIlham.setImageBitmap(data);
    }

    private void setSponsoredResource(){
        //get image
        ImageView ivVirtuaHive = (ImageView) fragmentView.findViewById(R.id.ivVirtuaHive);
        ImageView ivMaulidanGames = (ImageView) fragmentView.findViewById(R.id.ivMaulidanGames);
        ImageView ivRasyidTech = (ImageView) fragmentView.findViewById(R.id.ivRasyidTech);

        Bitmap data = mPresenter.compressImages(getContext(), R.drawable.logo_virtuahive, 140, 60);
        ivVirtuaHive.setImageBitmap(data);
        data = mPresenter.compressImages(getContext(), R.drawable.logo_maulidangames, 140, 60);
        ivMaulidanGames.setImageBitmap(data);
        data = mPresenter.compressImages(getContext(), R.drawable.logo_rasyidtechnologies, 140, 60);
        ivRasyidTech.setImageBitmap(data);
    }

    private void setSupportedResource(){
        ImageView ivSindika = (ImageView) fragmentView.findViewById(R.id.ivSindika);
        ImageView ivRasyid = (ImageView) fragmentView.findViewById(R.id.ivRasyidInst);
        ImageView ivTrustMedis = (ImageView) fragmentView.findViewById(R.id.ivTrustMedis);
        ImageView ivProfilku = (ImageView) fragmentView.findViewById(R.id.ivProfilku);
        ImageView ivAltera = (ImageView) fragmentView.findViewById(R.id.ivAlterra);

        Bitmap data = mPresenter.compressImages(getContext(), R.drawable.logo_sindika, 140, 60);
        ivSindika.setImageBitmap(data);
        data = mPresenter.compressImages(getContext(), R.drawable.logo_rasyidinstitute, 140, 60);
        ivRasyid.setImageBitmap(data);
        data = mPresenter.compressImages(getContext(), R.drawable.trustmedis, 140, 60);
        ivTrustMedis.setImageBitmap(data);
        data = mPresenter.compressImages(getContext(), R.drawable.logo_profilku, 140, 60);
        ivProfilku.setImageBitmap(data);
        data = mPresenter.compressImages(getContext(), R.drawable.alterra, 140, 60);
        ivAltera.setImageBitmap(data);
    }

    public void gotoNewTask(Intent intent){
        startActivity(intent);
    }

    public void setPresenter(AboutUsContract.Presenter presenter){
        mPresenter = presenter;
    }
}
