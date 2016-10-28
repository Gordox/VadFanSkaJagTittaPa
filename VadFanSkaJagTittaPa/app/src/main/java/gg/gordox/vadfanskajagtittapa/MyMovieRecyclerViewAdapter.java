package gg.gordox.vadfanskajagtittapa;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


class MyMovieRecyclerViewAdapter extends RecyclerView.Adapter<MyMovieRecyclerViewAdapter.ViewHolder> {

    private final List<Movie> movieList;


    MyMovieRecyclerViewAdapter(List<Movie> items) {
        movieList = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.movie = movieList.get(position);
        holder.tvTitle.setText(movieList.get(position).title);
        holder.tvGenre.setText(movieList.get(position).genre);
        holder.tvReleaseDate.setText(movieList.get(position).releaseDate);
        //holder.ivPoster.setImageResource(/*id here*/);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final TextView tvTitle;
        private final TextView tvGenre;
        private final TextView tvReleaseDate;
        private final ImageView ivPoster;
        private Movie movie;

        private ViewHolder(View view) {
            super(view);
            mView = view;
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvGenre = (TextView) view.findViewById(R.id.tvGenre);
            tvReleaseDate = (TextView) view.findViewById(R.id.tvReleaseDate);
            ivPoster = (ImageView) view.findViewById(R.id.ivPoster);
        }
    }
}