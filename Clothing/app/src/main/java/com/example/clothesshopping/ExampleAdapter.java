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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class ExampleAdapter extends RecyclerView.Adapter implements Filterable {
    private Context mContext;
    private ArrayList<ClothingItem> mExampleList;
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
        mExampleList = exampleList;
        mExampleListAll = new ArrayList<>();
        mExampleListAll.addAll(exampleList);
    }

    @Override
    public int getItemViewType(int position) {
//        if (position % 2 == 0) {
//            return 0;
//        }
//        return 1;

        if (mExampleList.get(position).getCreator().toLowerCase().contains("a")) {
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
            view = layoutInflater.inflate(R.layout.example_item, parent, false);
            return new ViewHolderOne(view);
        }

        view = layoutInflater.inflate(R.layout.another_row_item, parent, false);
        return new ViewHolderTwo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ClothingItem currentItem = mExampleList.get(position);

        String imageUrl = currentItem.getImageUrl();
        String creatorName = currentItem.getCreator();
        String likeCount = currentItem.getLikeCount();

        if (currentItem.getCreator().toLowerCase().contains("a")) {
            ViewHolderOne viewHolderOne = (ViewHolderOne) holder;
            viewHolderOne.mTextViewCreator.setText(creatorName);
            viewHolderOne.mTextViewLikes.setText("Likes: " + likeCount);
            Picasso.get().load(imageUrl).fit().centerInside().into(viewHolderOne.mImageView);
        }else {
            ViewHolderTwo viewHolderTwo = (ViewHolderTwo) holder;
            viewHolderTwo.mTextViewCreator.setText(creatorName);
            viewHolderTwo.mTextViewLikes.setText("Likes: " + likeCount);
            Picasso.get().load(imageUrl).fit().centerInside().into(viewHolderTwo.mImageView);
        }
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    @Override
    public Filter getFilter() {

        return myFilter;
    }

    Filter myFilter = new Filter() {

        //Automatic on background thread
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<ClothingItem> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(mExampleListAll);
            } else {
                for (ClothingItem Example: mExampleListAll) {
                    if (Example.getCreator().toLowerCase().contains(charSequence.toString().toLowerCase())) {
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
            mExampleList.clear();
            mExampleList.addAll((Collection<? extends ClothingItem>) filterResults.values);
            notifyDataSetChanged();
        }
    };

    class ViewHolderOne extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextViewCreator;
        public TextView mTextViewLikes;

        public ViewHolderOne(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes = itemView.findViewById(R.id.text_view_likes);

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
        public TextView mTextViewCreator;
        public TextView mTextViewLikes;

        public ViewHolderTwo(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes = itemView.findViewById(R.id.text_view_likes);

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