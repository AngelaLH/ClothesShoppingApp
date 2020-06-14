package com.example.clothesshopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class ExampleAdapter extends RecyclerView.Adapter implements Filterable {
    private Context mContext;
    private ArrayList<ClothingItem> mCLothingList;
    private ArrayList<ClothingItem> mExampleListAll;
    private OnItemClickListener mListener;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public ExampleAdapter(Context context, ArrayList<ClothingItem> exampleList) {
        mContext = context;
        mCLothingList = exampleList;
        mExampleListAll = new ArrayList<>();
        mExampleListAll.addAll(exampleList);
    }

    @Override
    public int getItemViewType(int position) {
        if ( mCLothingList.get(position).getOrders() > 241) {
            return 0;
        }
        return 1;
    }

    @NonNull
    @Override
    public  RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;

        if (viewType == 0) {
            view = layoutInflater.inflate(R.layout.row_item, parent, false);
            return new ViewHolderOne(view);
        }

        view = layoutInflater.inflate(R.layout.row_item, parent, false);
        return new ViewHolderTwo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ClothingItem currentItem = mCLothingList.get(position);
        String creatorName = currentItem.getClothesName();
        String likeCount = currentItem.getPrice();
        String orderCount = String.valueOf(currentItem.getOrders());

        if (currentItem.getOrders() > 241) {
            ViewHolderOne ViewHolderOne = (ViewHolderOne) holder;
            ViewHolderOne.mTextViewName.setText(creatorName);
            ViewHolderOne.mTextViewPrice.setText(likeCount);
            ViewHolderOne.mTextViewOrders.setText("\uD83D\uDE9A"+ orderCount + " Orders");

            int i = mContext.getResources().getIdentifier(
                    currentItem.getImagefilename(), "drawable",
                    mContext.getPackageName());
            ViewHolderOne.mImageView.setImageResource(i);
        }else {
            ViewHolderTwo viewHolderTwo = (ViewHolderTwo) holder;
            viewHolderTwo.mTextViewName.setText(creatorName);
            viewHolderTwo.mTextViewPrice.setText(likeCount);
            viewHolderTwo.mTextViewOrders.setText("\uD83D\uDE9A"+ orderCount + " Orders");

            int i = mContext.getResources().getIdentifier(
                    currentItem.getImagefilename(), "drawable",
                    mContext.getPackageName());
            viewHolderTwo.mImageView.setImageResource(i);
        }
    }

    @Override
    public int getItemCount() {
        return mCLothingList.size();
    }

    @Override
    public Filter getFilter() {

        return myFilter;
    }

    Filter myFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<ClothingItem> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(mExampleListAll);
            } else {
                for (ClothingItem Example: mExampleListAll) {
                    if (Example.getClothesName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filteredList.add(Example);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        //Automatic on UI thread
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mCLothingList.clear();
            mCLothingList.addAll((Collection<? extends ClothingItem>) filterResults.values);
            notifyDataSetChanged();
        }
    };

    class ViewHolderOne extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewName;
        public TextView mTextViewPrice;
        public TextView mTextViewOrders;

        public ViewHolderOne(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewName = itemView.findViewById(R.id.text_view_name);
            mTextViewPrice = itemView.findViewById(R.id.text_view_price);
            mTextViewOrders = itemView.findViewById(R.id.text_view_orders);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    class ViewHolderTwo extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextViewName;
        public TextView mTextViewPrice;
        public TextView mTextViewOrders;

        public ViewHolderTwo(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewName = itemView.findViewById(R.id.text_view_name);
            mTextViewPrice = itemView.findViewById(R.id.text_view_price);
            mTextViewOrders = itemView.findViewById(R.id.text_view_orders);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

}