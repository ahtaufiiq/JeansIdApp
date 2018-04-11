package makanbu.com.makanbu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import makanbu.com.makanbu.R;
import makanbu.com.makanbu.model.Makanan;

/**
 * Created by Labbaika Putri on 4/11/2018.
 */
public class DetailMenuAdapter extends RecyclerView.Adapter<DetailMenuAdapter.ViewHolder> {

    Context ceontext;
    ArrayList<Makanan> makananList;

    public DetailMenuAdapter(Context ceontext, ArrayList<Makanan> makananList) {
        this.ceontext = ceontext;
        this.makananList = makananList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Makanan makanan = makananList.get(position);

        holder.gambar_card.setImageResource(makanan.getGambar_card());
        holder.profileImage_card.setImageResource(makanan.getProfileImage_card());
        holder.hargaMakanan_card.setText(makanan.getHargaMakanan_card());
        holder.namaMenu_card.setText(makanan.getNamaMenu_card());
        holder.jumlahReview_card.setText(makanan.getJumlahReview_card());
        holder.rating_card.setNumStars(makanan.getRating_card());

    }

    @Override
    public int getItemCount() {
        return makananList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView gambar_card;
        ImageView profileImage_card;
        TextView namaMenu_card;
        TextView jumlahReview_card;
        RatingBar rating_card;
        TextView hargaMakanan_card;
        RelativeLayout cardView;

        public ViewHolder(View itemView) {
            super(itemView);

           gambar_card = itemView.findViewById(R.id.gambar_card);
           profileImage_card = itemView.findViewById(R.id.profileImage_card);
           namaMenu_card = itemView.findViewById(R.id.namaMenu_card);
           jumlahReview_card = itemView.findViewById(R.id.jumlahReview_card);
           rating_card = itemView.findViewById(R.id.rating_card);
           hargaMakanan_card = itemView.findViewById(R.id.hargaMakanan_card);
           cardView = itemView.findViewById(R.id.cardViewDetail);
        }
    }
}
