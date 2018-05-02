package makanbu.com.makanbu.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import makanbu.com.makanbu.Constants;
import makanbu.com.makanbu.R;
import makanbu.com.makanbu.activities.OrderActivity;
import makanbu.com.makanbu.model.Makanan;

/**
 * Created by Labbaika Putri on 4/11/2018.
 */
public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.ViewHolder> {

    Context context;
    List<Makanan> makananList;

    public MakananAdapter(Context context, List<Makanan> makananList) {
        this.context = context;
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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Makanan makanan = makananList.get(position);

        final FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        Glide.with(context)
                .load(makanan.getGambar_card())
                .into(holder.gambar_card);
        Glide.with(context)
                .load(makanan.getProfileImage_card())
                .into(holder.profileImage_card);
        int harga = Integer.parseInt(makanan.getHargaMakanan_card());
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        holder.hargaMakanan_card.setText(formatRupiah.format(harga));
        holder.namaMenu_card.setText(makanan.getNamaMenu_card());
        holder.jumlahReview_card.setText(makanan.getJumlahReview_card() + " Review");
        holder.rating_card.setNumStars(makanan.getRating_card());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair<View, String> pair1 = Pair.create(holder.itemView.findViewById(R.id.img_masakan), "image");
                Pair<View, String> pair2 = Pair.create(holder.itemView.findViewById(R.id.tv_nama_makanan), "title");
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, pair1, pair2);

                Intent i = new Intent(context, OrderActivity.class);
                i.putExtra(Constants.KEY_MAKANAN, makanan);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    context.startActivity(i, optionsCompat.toBundle());
                } else {
                    context.startActivity(i);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return makananList.size();
    }
}
