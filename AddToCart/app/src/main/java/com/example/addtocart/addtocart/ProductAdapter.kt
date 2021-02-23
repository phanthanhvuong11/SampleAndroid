package com.example.addtocart.addtocart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.addtocart.R

class ProductAdapter(
) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var mListProduct: List<Product>? = null
    private var mIAddToCartProduct: IAddToCartProduct? = null

    interface IAddToCartProduct {
        fun onClickAddToCart(imgAddToCart: ImageView?, product1: Product?)
    }

    fun setData(list: List<Product>?, iAddToCartProduct: IAddToCartProduct?) {
        mListProduct = list
        mIAddToCartProduct = iAddToCartProduct
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = mListProduct?.get(position) ?: return
        product.resourceId?.let { holder.imgProduct.setImageResource(it) }
        holder.tvNameProduct.text = product.name
        holder.tvDescription.text = product.description
        if (product.isAddToCart) {
            holder.imgAddToCart.setBackgroundResource(R.drawable.bg_gray_conner_6)
        }else{
            holder.imgAddToCart.setBackgroundResource(R.drawable.bg_red_conner_6)
        }

        holder.imgAddToCart.setOnClickListener {
            if (!(product.isAddToCart)) {
                mIAddToCartProduct?.onClickAddToCart(
                    holder.imgAddToCart,
                    product
                )
            }

        }
    }

    override fun getItemCount(): Int {
        return mListProduct?.size!!
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgProduct: ImageView = itemView.findViewById(R.id.imgProduct)
        val imgAddToCart: ImageView = itemView.findViewById(R.id.imgCart)
        val tvNameProduct: TextView = itemView.findViewById(R.id.tvProductName)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)

    }
}