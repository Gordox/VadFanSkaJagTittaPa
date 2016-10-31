package gg.gordox.vadfanskajagtittapa;

import android.app.Fragment;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

class MyMovieRecyclerViewAdapter implements ExpandableListAdapter {

    private final List<Movie> movieList;

    LayoutInflater mInflater;

    MyMovieRecyclerViewAdapter(List<Movie> items, Fragment parent) {

        movieList = items;
        mInflater = (LayoutInflater) parent.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return movieList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {

        return movieList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return movieList.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return movieList.size()+childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.fragment_movie, parent, false);

        Movie movie = movieList.get(groupPosition);

        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        TextView tvGenre = (TextView) view.findViewById(R.id.tvGenre);
        TextView tvReleaseDate = (TextView) view.findViewById(R.id.tvReleaseDate);
        ImageView ivPoster = (ImageView) view.findViewById(R.id.ivPoster);

        tvTitle.setText(movie.title);
        tvGenre.setText(movie.genre);
        tvReleaseDate.setText(movie.releaseDate);
        //ivPoster.setImageResource(movie.imageUrl);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(movie.imageUrl, ivPoster);

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.fragment_movie_child_layout, parent, false);

        Log.e("SIMON GROUPPOS", groupPosition + "");
        Log.e("SIMON CHILDPOS", childPosition + "");

        TextView tvPlot = (TextView) view.findViewById(R.id.tvPlot);

        String temp = movieList.get(groupPosition).plot;
        Log.e("SIMON SAYS", temp);

        tvPlot.setText(temp);
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }


}