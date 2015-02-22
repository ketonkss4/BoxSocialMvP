package com.example.administrator.boxsocialmvp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2/21/2015.
 */
public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.MyViewholder> {

    private final LayoutInflater inflator;
    private final Context context;
    List<TvCard> tvCards = Collections.emptyList();

    public ShowAdapter(Context context, List<TvCard> tvCards) {
        inflator = LayoutInflater.from(context);
        this.context = context;
        this.tvCards = tvCards;
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflator.inflate(R.layout.show_list_row,viewGroup,false);
        return new MyViewholder(view);
    }



    @Override
    public void onBindViewHolder(MyViewholder myViewholder, int position) {
        TvCard current = tvCards.get(position);
        myViewholder.showtitle.setText(current.showTitle);
        myViewholder.showtime.setText(current.showTime);
        myViewholder.showNetwork.setText(current.network);
        myViewholder.chatter.setText(current.chatter);
        Log.e("SHOWADAPTER","ImgUrl:"+current.previewImg);
        Picasso.with(context).load(current.previewImg).error(R.drawable.ic_book_black_48dp).into(myViewholder.showImg);


    }


    @Override
    public int getItemCount() {
        return tvCards.size();
    }

    class MyViewholder extends RecyclerView.ViewHolder{
        TextView showtitle;
        TextView showtime;
        TextView showNetwork;
        TextView chatter;
        ImageView showImg;

        public MyViewholder(View itemView) {
            super(itemView);
            showtime = (TextView) itemView.findViewById(R.id.showTime);
            showtitle = (TextView) itemView.findViewById(R.id.showTitle);
            showNetwork = (TextView) itemView.findViewById(R.id.showNetwork);
            chatter = (TextView) itemView.findViewById(R.id.chatter);
            showImg = (ImageView) itemView.findViewById(R.id.showImg);

        }
    }
}