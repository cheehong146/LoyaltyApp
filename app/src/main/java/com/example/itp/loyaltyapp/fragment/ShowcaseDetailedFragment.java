package com.example.itp.loyaltyapp.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.itp.loyaltyapp.R;
import com.example.itp.loyaltyapp.base.BaseFragment;
import com.example.itp.loyaltyapp.databinding.FragmentShowcaseDetailedBinding;
import com.example.itp.loyaltyapp.model.Customer;
import com.example.itp.loyaltyapp.model.Item;
import com.example.itp.loyaltyapp.model.ShowcaseItem;

public class ShowcaseDetailedFragment extends BaseFragment implements View.OnClickListener {

    private ShowcaseItem item;
    String vendorName;

    FragmentShowcaseDetailedBinding binding;

    ReadMoreTextView tvDescription, tvTermsAndCondition, tvValidDate;
    TextView tvFoodName;
    ImageView ivFoodImage;

    public static ShowcaseDetailedFragment newInstance(Customer customer, Item item, String vendorName) {
        Bundle args = new Bundle();
        args.putParcelable("showcaseItem", item);
        args.putString("vendorName", vendorName);
        ShowcaseDetailedFragment fragment = new ShowcaseDetailedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try{
            item = getArguments().getParcelable("showcaseItem");
            vendorName = getArguments().getString("vendorName");
        }catch (NullPointerException e){
            e.printStackTrace();//TODO EH
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_showcase_detailed, container, false);

        initComponents();
        setupViewWithData();

        return binding.getRoot();
    }

    private void setupViewWithData(){
        tvFoodName.setText(item.getName());
        tvDescription.setText(item.getDesc());
        tvValidDate.setText(item.getValidityDate());
        tvTermsAndCondition.setText(item.getTermsAndCondition());

        Glide.with(this)
                .asBitmap()
                .transform(new CenterCrop(), new RoundedCorners(16))
                .load(item.getImgUrl())
                .into(ivFoodImage);
    }

    @Override
    public void bindComponents() {
        //not using data binding cause expand text view library doesn't support it
        tvDescription = binding.getRoot().findViewById(R.id.tv_showcase_detailed_description);
        tvTermsAndCondition = binding.getRoot().findViewById(R.id.tv_showcase_detailed_terms_condition_content);
        tvValidDate = binding.getRoot().findViewById(R.id.tv_showcase_detailed_valid_date_content);

        tvFoodName = binding.tvShowcaseDetailedTitle;
        ivFoodImage = binding.ivShowcaseDetailed;
    }

    @Override
    public void setupListener() {
        tvDescription.setOnClickListener(this);
        tvTermsAndCondition.setOnClickListener(this);
        tvValidDate.setOnClickListener(this);
    }

    @Override
    public void initComponents() {
        bindComponents();
    }
}
