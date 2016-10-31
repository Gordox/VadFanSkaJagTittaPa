package gg.gordox.vadfanskajagtittapa;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

public class MovieListFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);

        getActivity().setTitle("Recommendations");

        Context context = view.getContext();
        ExpandableListView recyclerView = (ExpandableListView) view.findViewById(R.id.movieListLayout);
        //recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new MyMovieRecyclerViewAdapter(OmdbController.getInstance().getMovies(), this));
        return view;
    }
}
