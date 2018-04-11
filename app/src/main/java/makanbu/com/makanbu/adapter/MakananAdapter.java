package makanbu.com.makanbu.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import makanbu.com.makanbu.R;
import makanbu.com.makanbu.model.Makanan;

/**
 * Created by Labbaika Putri on 4/11/2018.
 */
public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.ViewHolder> {

    Context ceontext;
    List<Makanan> makananList;

    public MakananAdapter(Context ceontext, List<Makanan> makananList) {
        this.ceontext = ceontext;
        this.makananList = makananList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView gambar_card;
        ImageView profileImage_card;
        TextView namaMenu_card;
        TextView jumlahReview_card;
        RatingBar rating_card;
        TextView hargaMakanan_card;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            gambar_card = itemView.findViewById(R.id.img_masakan);
            profileImage_card = itemView.findViewById(R.id.img_avatar);
            namaMenu_card = itemView.findViewById(R.id.tv_nama_makanan);
            jumlahReview_card = itemView.findViewById(R.id.tv_jumlah_review);
            rating_card = itemView.findViewById(R.id.rb_makanan);
            hargaMakanan_card = itemView.findViewById(R.id.hargaMakanan_card);
            cardView = itemView.findViewById(R.id.cv_product);
        }
    }

    public MakananAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Makanan makanan = makananList.get(position);

        holder.gambar_card.setImageResource(makanan.getGambar_card());
        holder.profileImage_card.setImageResource(makanan.getProfileImage_card());
        holder.hargaMakanan_card.setText(makanan.getHargaMakanan_card());
        holder.namaMenu_card.setText(makanan.getNamaMenu_card());
        holder.jumlahReview_card.setText(makanan.getJumlahReview_card()+" Review");
        holder.rating_card.setNumStars(makanan.getRating_card());

    }

    @Override
    public int getItemCount() {
        return makananList.size();
    }
}
