package makanbu.com.makanbu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Labbaika Putri on 3/26/2018.
 */

public class detailAdapter extends RecyclerView.Adapter<detailAdapter.holdermenu> {
    CardView cardView;
    private Context context;
    private List<detailMenuList> daftar_menus;

    public detailAdapter(Context context, List<detailMenuList> daftar_menus) {
        this.context = context;
        this.daftar_menus = daftar_menus;
    }


    @Override
    public detailAdapter.holdermenu onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_detail, parent, false);
        holdermenu holder = new holdermenu(view, this);
        return holder;
    }

    @Override
    public void onBindViewHolder(detailAdapter.holdermenu holder, int position) {
        detailMenuList daftarMenus = daftar_menus.get(position);
        holder.gambar_card.setTag(daftarMenus.getGambar_card());
        holder.profile_image.setTag(daftarMenus.getProfileImage_card());
        holder.namaMenu_card.setText((CharSequence) daftarMenus.getNamaMenu_card());
        holder.jumlahReview_card.setText((CharSequence) daftarMenus.getJumlahReview_card());
        holder.hargaMakanan_card.setText((CharSequence) daftarMenus.getHargaMakanan_card());
        holder.rating_card.setIsIndicator(true);

    }

    @Override
    public int getItemCount() {
        return daftar_menus.size();
    }

    public class holdermenu extends RecyclerView.ViewHolder{
        ImageView gambar_card, profile_image;
        TextView namaMenu_card, jumlahReview_card, hargaMakanan_card;
        RatingBar rating_card;
        final detailAdapter madapter;

        public holdermenu(View itemView, detailAdapter madapter) {
            super(itemView);
            gambar_card = itemView.findViewById(R.id.gambar_card);
            profile_image = itemView.findViewById(R.id.profileImage_card);
            namaMenu_card = itemView.findViewById(R.id.namaMenu_card);
            jumlahReview_card = itemView.findViewById(R.id.jumlahReview_card);
            hargaMakanan_card = itemView.findViewById(R.id.hargaMakanan_card);
            rating_card = itemView.findViewById(R.id.rating_card);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                //Ketika item diklik
                public void onClick(View iview) {
                    Intent intent = new Intent (context, detailMenuList.class );

                    intent.putExtra("gambar_card" , gambar_card.getTag().toString());
                    intent.putExtra("profileImage_card", profile_image.getTag().toString());
                    intent.putExtra("namaMenu_card", namaMenu_card.getText());
                    intent.putExtra("hargaMakanan_card", hargaMakanan_card.getText());
                    intent.putExtra("jumlahReview_card", jumlahReview_card.getText());
                    intent.putExtra("rating_card", rating_card.getRating());
                    context.startActivity(intent);
                }
            });

            this.madapter = madapter;
        }
    }
}
