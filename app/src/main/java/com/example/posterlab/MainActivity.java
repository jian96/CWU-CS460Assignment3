package com.example.posterlab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PostersListener{
    private Button buttonAddtoWatchList;

    /**
     * This main onCreate startup function for the app, it will first bind to the postersRecyclerView
     * and add to watchlist button.
     *
     * It will then statically create 10 movie entries to populate the posters list. Finally it will
     * create functionality for clicking on the add to watchlist button, that is to retrieve the
     * list of selected posters and display a Toast indicating which movies have been added to the watch list
     * after clicking the add to watchlist button
     * @param savedInstanceState Saved UI state of the app
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView postersRecyclerView = findViewById(R.id.postersRV);
        buttonAddtoWatchList = findViewById(R.id.buttonAddToWatchlist);

        // Data
        List<Poster> posterList = new ArrayList<>();

// Movie one
        Poster movie_one = new Poster();
        movie_one.image = R.drawable.movie_one;
        movie_one.name = "Serial Experiments Lain";
        movie_one.createdBy = "Ryūtarō Nakamura";
        movie_one.rating = 4.045f;
        movie_one.storyDesc = "Lain Iwakura, an awkward and introverted fourteen-year-old, is one of the many girls from her school to receive a disturbing email from her classmate Chisa Yomoda—the very same Chisa who recently committed suicide. Lain has neither the desire nor the experience to handle even basic technology; yet, when the technophobe opens the email, it leads her straight into the Wired, a virtual world of communication networks similar to what we know as the internet. Lain's life is turned upside down as she begins to encounter cryptic mysteries one after another. Strange men called the Men in Black begin to appear wherever she goes, asking her questions and somehow knowing more about her than even she herself knows. With the boundaries between reality and cyberspace rapidly blurring, Lain is plunged into more surreal and bizarre events where identity, consciousness, and perception are concepts that take on new meanings.";

// Movie two
        Poster movie_two = new Poster();
        movie_two.image = R.drawable.movie_two;
        movie_two.name = "Aria the Animation";
        movie_two.createdBy = "Junichi Sato";
        movie_two.rating = 3.84f;
        movie_two.storyDesc = "Drift peacefully into Neo Venezia, a city on the planet Aqua (formerly known as Mars). By the 24th century, humans have found a way to colonize the previously uninhabitable planet. As futuristic as that sounds, Neo Venezia is still teeming with rustic beauty; gondolas on wide canals and waterways are the main mode of transportation. The city itself is a faithful replication of Manhome's (the planet formerly known as Earth) Venice.";

// Movie three
        Poster movie_three = new Poster();
        movie_three.image = R.drawable.movie_three;
        movie_three.name = "Elfen Lied";
        movie_three.createdBy = "Mamoru Kanbe";
        movie_three.rating = 3.73f;
        movie_three.storyDesc = "Lucy is a special breed of human referred to as \"Diclonius,\" born with a short pair of horns and invisible telekinetic hands that lands her as a victim of inhumane scientific experimentation by the government. However, once circumstances present her an opportunity to escape, Lucy, corrupted by the confinement and torture, unleashes a torrent of bloodshed as she escapes her captors.";

// Movie four
        Poster movie_four = new Poster();
        movie_four.image = R.drawable.movie_four;
        movie_four.name = "Higurashi no Naku Koro ni";
        movie_four.createdBy = "Chiaki Kon";
        movie_four.rating = 3.93500f;
        movie_four.storyDesc = "Keiichi Maebara has just moved to the quiet little village of Hinamizawa in the summer of 1983, and quickly becomes inseparable friends with schoolmates Rena Ryuuguu, Mion Sonozaki, Satoko Houjou, and Rika Furude. However, darkness lurks underneath the seemingly idyllic life they lead.";

// Movie five
        Poster movie_five = new Poster();
        movie_five.image = R.drawable.movie_five;
        movie_five.name = "Sketchbook ~full color's~";
        movie_five.createdBy = "Yoshimasa Hiraike";
        movie_five.rating = 3.68500f;
        movie_five.storyDesc = "To Sora Kajiwara, the world is full of wonderful and adorable things she wants to draw—cats being a popular object of her affection. Even though there are some things that can't be captured with a pencil and paper, she still brings her sketchbook wherever she goes. Her love of drawing eventually leads her to join her school's art club, despite her shy and childish personality.";

// Movie six
        Poster movie_six = new Poster();
        movie_six.image = R.drawable.movie_six;
        movie_six.name = "Angel Beats!";
        movie_six.createdBy = "Seiji Kishi";
        movie_six.rating = 4.02500f;
        movie_six.storyDesc = "Death is one of many mysteries that has left humanity in the dark since the dawn of time. However, the burning question of what happens to the soul after one dies is soon answered to 17-year-old Yuzuru Otonashi. Waking up with no previous memories in a dimension between life and death, he discovers the unsettling truth of the afterlife.";

// Movie seven
        Poster movie_seven = new Poster();
        movie_seven.image = R.drawable.movie_seven;
        movie_seven.name = "Soul Eater";
        movie_seven.createdBy = "Takuya Igarashi";
        movie_seven.rating = 3.92500f;
        movie_seven.storyDesc = "Death City is home to the famous Death Weapon Meister Academy, a technical academy headed by the Shinigami—Lord Death himself. Its mission: to raise \"Death Scythes\" for the Shinigami to wield against the many evils of their fantastical world. These Death Scythes, however, are not made from physical weapons; rather, they are born from human hybrids who have the ability to transform their bodies into Demon Weapons, and only after they have consumed the souls of 99 evil beings and one witch's soul.";

// Movie eight
        Poster movie_eight = new Poster();
        movie_eight.image = R.drawable.movie_eight;
        movie_eight.name = "Ika Musume";
        movie_eight.createdBy = "Tsutomu Mizushima";
        movie_eight.rating = 3.70500f;
        movie_eight.storyDesc = "Humans have been polluting the ocean for a long time, carelessly pouring their garbage and desecrating the waters that many creatures call home. The denizens of the sea have suffered at their poisoning hands. Finally, one certain squid has had enough and vows to punish the humans' selfish actions.";

// Movie nine
        Poster movie_nine = new Poster();
        movie_nine.image = R.drawable.movie_nine;
        movie_nine.name = "A Certain Scientific Railgun";
        movie_nine.createdBy = "Tatsuyuki Nagai";
        movie_nine.rating = 3.83f;
        movie_nine.storyDesc = "The student-filled Academy City is at the forefront of scientific advancement and home to the esper development program. The seven \"Level 5\" espers are the most powerful in Academy City, and ranked third among them is middle schooler Mikoto Misaka, an electricity manipulator known as \"The Railgun.\"";

// Movie ten
        Poster movie_ten = new Poster();
        movie_ten.image = R.drawable.movie_ten;
        movie_ten.name = "Rozen Maiden: Träumend";
        movie_ten.createdBy = "Kou Matsuo";
        movie_ten.rating = 3.80500f;
        movie_ten.storyDesc = "As the story of Rozen Maiden closes, a new chapter begins in Rozen Maiden: Träumend. Shinku and the other sentient dolls of the Rozen Maiden collection are living life as usual at Jun Sakurada's house. Having settled into his role as Shinku's partner in the deadly Alice Game, Jun overcomes his former fears and prepares to return to school. And although Shinku and the other dolls idly pass the days by in the comfort of Jun's home, dark times lie ahead as a new foe presents herself: Barasuishou, the seventh Rozen Maiden.";

        posterList.add(movie_one);
        posterList.add(movie_two);
        posterList.add(movie_three);
        posterList.add(movie_four);
        posterList.add(movie_five);
        posterList.add(movie_six);
        posterList.add(movie_seven);
        posterList.add(movie_eight);
        posterList.add(movie_nine);
        posterList.add(movie_ten);

        final PosterAdapter posterAdapter = new PosterAdapter(posterList, this, MainActivity.this);
        postersRecyclerView.setAdapter(posterAdapter);
        buttonAddtoWatchList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Poster> selectPosters = posterAdapter.getSelectedPosters();

                StringBuilder posterNames = new StringBuilder();
                for (int i = 0; i < selectPosters.size();i++){
                    if (i == 0){
                        posterNames.append(selectPosters.get(i).name);
                    } else {
                        posterNames.append("\n").append(selectPosters.get(i).name);
                    }
                }
                Toast.makeText(MainActivity.this, posterNames.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * This function sets the visibility of the add to watchlist button, based on whether or not
     * a poster has been selected
     * @param isSelected True/false for if a poster is selected or not
     */
    @Override
    public void onPosterAction(Boolean isSelected) {
        if (isSelected){
            buttonAddtoWatchList.setVisibility(View.VISIBLE);
        } else {
            buttonAddtoWatchList.setVisibility(View.GONE);
        }
    }
}