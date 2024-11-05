package com.example.posterlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class PosterAdapter extends RecyclerView.Adapter<PosterAdapter.PosterViewHolder>{
    private List<Poster> posterList;
    private Context mainActivityContext;

    /**
     * Constructor for PosterAdapter, initializes with the given params
     * @param posterList A List of Poster objects
     * @param postersListener A boolean value to hold whether or not a poster is selected
     */
    public PosterAdapter(List<Poster> posterList, PostersListener postersListener, Context context) {
        this.mainActivityContext = context;
        this.posterList = posterList;
        this.postersListener = postersListener;
    }
    private PostersListener postersListener;

    /**
     * This function retrieves the Poster objects from the posterList List and creates
     * an ArrayList to populate the Poster objects and returns them
     * @return The ArrayList to return, containing Poster objects that the PosterAdapter currently has
     */
    public List<Poster> getSelectedPosters(){
        List<Poster> selectedPosters = new ArrayList<>();
        for (Poster poster : this.posterList){
            if (poster.isSelected){
                selectedPosters.add(poster);
            }
        }
        return selectedPosters;
    }

    /**
     * Function used to create and render a new Poster object
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return
     */
    @NonNull
    @Override
    public PosterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PosterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_poster, parent, false));
    }

    /**
     * Function that calls on binding a PosterViewHolder, used to populate the new Poster object with resources
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull PosterViewHolder holder, int position) {
        holder.bindPosters(posterList.get(position));

    }

    /**
     * Returns the size of the posters list
     * @return Size of the posterList List
     */
    @Override
    public int getItemCount() {
        return posterList.size();
    }

    /**
     * This is the object that will contain a specific poster
     */
    class PosterViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout layoutPosters;
        View viewBackground;
        RoundedImageView imagePoster;
        TextView textName, textCreatedBy, textStoryDesc;
        RatingBar ratingBar;
        ImageView imageSelected;

        /**
         * Constructor for the class, binds members fields with UI View component
         * @param itemView A View component defined in XML
         */
        public PosterViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutPosters = itemView.findViewById(R.id.layoutPosters);
            viewBackground = itemView.findViewById(R.id.viewBackground);
            imagePoster = itemView.findViewById(R.id.imagePosters);
            textName = itemView.findViewById(R.id.imagePostersTextName);
            textCreatedBy = itemView.findViewById(R.id.textCreateBy);
            textStoryDesc = itemView.findViewById(R.id.textStoryDescription);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            imageSelected = itemView.findViewById(R.id.imageSelected);
        }

        /**
         * This function sets all the necessary resources used to render a poster
         * including poster image, movie name, author, rating, and story description
         * It will also handle the selection box around the poster's visibility, maknig it appear
         * when the poster is selected and disappearing when unselected
         *
         * It also implements a listener for clicks on the poster itself
         * @param poster
         */
        void bindPosters(final Poster poster){
            imagePoster.setImageResource(poster.image);
            textName.setText(poster.name);
            textCreatedBy.setText(poster.createdBy);
            textStoryDesc.setText(poster.storyDesc);
            ratingBar.setRating(poster.rating);
            if (poster.isSelected){
                viewBackground.setBackgroundResource(R.drawable.poster_selected_background);
                imageSelected.setVisibility(View.VISIBLE);
            } else {
                viewBackground.setBackgroundResource(R.drawable.poster_background);
                imageSelected.setVisibility(View.GONE);
            }

            layoutPosters.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (poster.isSelected) {
                        viewBackground.setBackgroundResource(R.drawable.poster_background);
                        imageSelected.setVisibility(View.GONE);
                        Toast.makeText(mainActivityContext, "Unselected " + poster.name,Toast.LENGTH_SHORT).show();
                        poster.isSelected = false;
                        if (getSelectedPosters().isEmpty()) {
                            postersListener.onPosterAction(false);
                        }
                    } else {
                        viewBackground.setBackgroundResource(R.drawable.poster_selected_background);
                        imageSelected.setVisibility(View.VISIBLE);
                        Toast.makeText(mainActivityContext, "Selected " + poster.name,Toast.LENGTH_SHORT).show();
                        poster.isSelected = true;
                        postersListener.onPosterAction(true);
                    }
                }
            });

        }


    }
}
