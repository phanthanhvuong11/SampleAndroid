package com.example.addtocart.addtocart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment1 extends Fragment {
//    private RecyclerView rcvProduct;
//    private View view;
//    private MainActivity mainActivity;
//    private ProductAdapter1 productAdapter1;
//
//    public ProductFragment1() {
//
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.fragment_product, container, false);
//        mainActivity = (MainActivity) getActivity();
//        rcvProduct = view.findViewById(R.id.recycleViewProduct);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
//        rcvProduct.setLayoutManager(linearLayoutManager);
//        productAdapter1 = new ProductAdapter1();
//        productAdapter1.setData(getListProduct(), new ProductAdapter1.IAddToCartProduct() {
//            @Override
//            public void onClickAddToCart(ImageView imgAddToCart, Product1 product1) {
//
//            }
//        });
//        rcvProduct.setAdapter(productAdapter1);
//        return view;
//    }
//
//    private List<Product1> getListProduct() {
//        List<Product1> listProduct = new ArrayList<>();
//        listProduct.add(new Product1(R.drawable.product1, "Product name 1", "This is description"));
//        listProduct.add(new Product1(R.drawable.product2, "Product name 2", "This is description"));
//        listProduct.add(new Product1(R.drawable.product1, "Product name 3", "This is description"));
//        listProduct.add(new Product1(R.drawable.product2, "Product name 4", "This is description"));
//        listProduct.add(new Product1(R.drawable.product1, "Product name 5", "This is description"));
//        listProduct.add(new Product1(R.drawable.product2, "Product name 6", "This is description"));
//        listProduct.add(new Product1(R.drawable.product1, "Product name 7", "This is description"));
//        listProduct.add(new Product1(R.drawable.product2, "Product name 8", "This is description"));
//        listProduct.add(new Product1(R.drawable.product1, "Product name 9", "This is description"));
//        listProduct.add(new Product1(R.drawable.product2, "Product name 10", "This is description"));
//        listProduct.add(new Product1(R.drawable.product1, "Product name 11", "This is description"));
//        listProduct.add(new Product1(R.drawable.product2, "Product name 12", "This is description"));
//        listProduct.add(new Product1(R.drawable.product1, "Product name 13", "This is description"));
//        listProduct.add(new Product1(R.drawable.product2, "Product name 14", "This is description"));
//        listProduct.add(new Product1(R.drawable.product1, "Product name 15", "This is description"));
//        listProduct.add(new Product1(R.drawable.product2, "Product name 16", "This is description"));
//        listProduct.add(new Product1(R.drawable.product1, "Product name 17", "This is description"));
//        listProduct.add(new Product1(R.drawable.product2, "Product name 18", "This is description"));
//        listProduct.add(new Product1(R.drawable.product1, "Product name 19", "This is description"));
//        return listProduct;
//    }
}
