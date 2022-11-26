package com.example.indianewsfeed.ui.home;

 import android.annotation.SuppressLint;
 import android.content.Context;
 import android.view.LayoutInflater;
 import android.view.ViewGroup;
 import androidx.annotation.NonNull;
 import androidx.recyclerview.widget.RecyclerView;

 import com.example.indianewsfeed.Models.Headlines;
 import com.example.indianewsfeed.R;
 import com.squareup.picasso.Picasso;

 import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder>
{
    private final Context context;
    private final List<Headlines> headlines;
    private final SelectListener listener;


    public HomeAdapter(Context context, List<Headlines> headlines ,SelectListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener= listener;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
        holder.text_title.setText(headlines.get(position).getTitle());
        holder.text_source.setText(headlines.get(position).getSource().getName());

        if(headlines.get(position).getUrlToImage()!=null)
        {
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);
        }

        holder.cardView.setOnClickListener(view -> listener.OnNewsClicked(headlines.get(position)));
    }

    @Override
    public int getItemCount()
    {
        return headlines.size();
    }
}
