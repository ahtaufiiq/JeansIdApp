package makanbu.com.makanbu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import makanbu.com.makanbu.R;
import makanbu.com.makanbu.model.Notification;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    Context context;
    List<Notification> makananList;

    public NotificationAdapter(Context context, List<Notification> makananList) {
        this.context = context;
        this.makananList = makananList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.circleImageView);
            textView = itemView.findViewById(R.id.text);
        }
    }

    public NotificationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_notif, parent, false);
        return new NotificationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NotificationAdapter.ViewHolder holder, int position) {
        final Notification makanan = makananList.get(position);

        Glide.with(context)
                .load(makanan.getId())
                .into(holder.imageView);
        holder.textView.setText(makanan.getText());


    }

    @Override
    public int getItemCount() {
        return makananList.size();
    }
}
