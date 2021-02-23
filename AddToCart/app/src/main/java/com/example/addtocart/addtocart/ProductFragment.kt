package com.example.addtocart.addtocart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.addtocart.R

class ProductFragment : Fragment() {
    companion object {
        fun newInstance() =
            ProductFragment()
    }

    private var rcvProduct: RecyclerView? = null
    private var mainActivity: MainActivity? = null
    private var productAdapter: ProductAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product, container, false)
        mainActivity = activity as MainActivity?
        rcvProduct = view?.findViewById(R.id.recycleViewProduct)
        val linearLayoutManager = LinearLayoutManager(mainActivity)
        rcvProduct?.layoutManager = linearLayoutManager
        productAdapter = ProductAdapter()
        productAdapter?.setData(getListProduct(), object : ProductAdapter.IAddToCartProduct {
            override fun onClickAddToCart(imgAddToCart: ImageView?, product1: Product?) {
                mainActivity?.let {
                    mainActivity?.viewEndAnimation?.let { it1 ->
                        imgAddToCart?.let { it2 ->
                            AnimationUtils().translateAnimation(it.imgAnimation, it2,
                                it1, object : Animation.AnimationListener {
                                    override fun onAnimationStart(animation: Animation?) {

                                    }

                                    override fun onAnimationEnd(animation: Animation?) {
                                        product1?.isAddToCart = true
                                        imgAddToCart.setBackgroundResource(R.drawable.bg_gray_conner_6)
                                        productAdapter?.notifyDataSetChanged()

                                        mainActivity?.mCountProduct?.plus(1)?.let { it3 ->
                                            mainActivity?.setCountProductInCart(
                                                it3
                                            )
                                        }
                                    }

                                    override fun onAnimationRepeat(animation: Animation?) {

                                    }

                                })
                        }
                    }
                }
            }
        })
        rcvProduct?.adapter = productAdapter
        return view
    }

    private fun getListProduct(): List<Product>? {
        val listProduct: MutableList<Product> = mutableListOf()
        listProduct.add(
            Product(
                R.drawable.product1,
                "Product name 1",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product2,
                "Product name 2",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product1,
                "Product name 3",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product2,
                "Product name 4",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product1,
                "Product name 5",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product2,
                "Product name 6",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product1,
                "Product name 7",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product2,
                "Product name 8",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product1,
                "Product name 9",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product2,
                "Product name 10",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product1,
                "Product name 11",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product2,
                "Product name 12",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product1,
                "Product name 13",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product2,
                "Product name 14",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product1,
                "Product name 15",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product2,
                "Product name 16",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product1,
                "Product name 17",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product2,
                "Product name 18",
                "This is description",
                false
            )
        )
        listProduct.add(
            Product(
                R.drawable.product1,
                "Product name 19",
                "This is description",
                false
            )
        )
        return listProduct
    }
}