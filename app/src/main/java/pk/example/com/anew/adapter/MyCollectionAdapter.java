package pk.example.com.anew.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import pk.example.com.anew.R;
import pk.example.com.anew.activity.BrowerNewsActivity;
import pk.example.com.anew.application.MyApplication;
import pk.example.com.anew.model.CollectBean;


public class MyCollectionAdapter extends BaseAdapter {
    private List<CollectBean> mCollectBeen = new ArrayList<>();
    private Context mContext;

    public MyCollectionAdapter(List<CollectBean> collectBeen, Context mContext) {
        this.mCollectBeen = collectBeen;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mCollectBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return mCollectBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (null == convertView) {
            viewHolder = new ViewHolder();
            LayoutInflater mInflater = LayoutInflater.from(mContext);
            convertView = mInflater.inflate(R.layout.collection_list_item, null);
            viewHolder.mTvTitie = (TextView) convertView.findViewById(R.id.tv_collection_content);
            viewHolder.mIvTitle = (ImageView) convertView.findViewById(R.id.iv_collection_title);
            viewHolder.mTvCollectionTime = (TextView) convertView.findViewById(R.id.tv_collection_time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final CollectBean collectBean = mCollectBeen.get(position);
        viewHolder.mTvTitie.setText(collectBean.getTitle());
        viewHolder.mTvCollectionTime.setText(collectBean.getCollectTime());
        final View finalConvertView = convertView;
        viewHolder.mTvTitie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyApplication.getContext(), BrowerNewsActivity.class);
                intent.putExtra("url", collectBean.getContentUrl());
                finalConvertView.getContext().startActivity(intent);
            }
        });
        Glide.with(viewHolder.mIvTitle.getContext()).load(collectBean.getImgUrl()).into(viewHolder.mIvTitle);

        return convertView;
    }

    public void changeData(List<CollectBean> collectBeen) {
        this.mCollectBeen = collectBeen;
        notifyDataSetChanged();
    }

    private static class ViewHolder {
        private ImageView mIvTitle;
        private TextView mTvTitie;
        private TextView mTvCollectionTime;

    }
}
