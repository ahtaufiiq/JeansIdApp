package makanbu.com.makanbu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import makanbu.com.makanbu.R;
import makanbu.com.makanbu.model.Makanan;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.ViewHolder> {

    Context context;
    List<Makanan> postList;

    public MakananAdapter(Context context, List<Makanan> postList) {
        this.context = context;
        this.postList = postList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mUsername;
        TextView mComment;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
//            imageView=itemView.findViewById(R.id.img_avatar);
            mUsername=itemView.findViewById(R.id.tv_username);
            mComment=itemView.findViewById(R.id.tv_comment);
        }
    }

    @NonNull
    @Override
    public MakananAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_comment,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Makanan comment= postList.get(position);

        holder.mUsername.setText(comment.getNamaMakanan());
        holder.mComment.setText(comment.getHargaMakanan());

    }
//    private void setupImageRounded() {
//        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.test);
//        rounded = RoundedBitmapDrawableFactory.create(context.getResources(), bitmap);
//        rounded.setCircular(true);
//
//    }

    @Override
    public int getItemCount() {
        return postList.size();
    }



}
