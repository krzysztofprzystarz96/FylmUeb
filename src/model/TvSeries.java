package model;

import java.util.Objects;

public class TvSeries extends Item {
    private int seasons;
    private int episodes;
    private String producer;

    public TvSeries(String name, int seasons, int episodes, String producer, String genre,
                    String description, int rating) {
        super(name, genre, description, rating);
        this.producer = producer;
        this.seasons = seasons;
        this.episodes = episodes;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TvSeries tvSeries = (TvSeries) o;
        return seasons == tvSeries.seasons && episodes == tvSeries.episodes && Objects.equals(producer, tvSeries.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seasons, episodes, producer);
    }

    @Override
    public String toString() {
        return getName() + ", the number of seasons: " +
                seasons + ", the number of episodes: " +
                episodes + ", producer: " +
                producer + ", genre: " +
                getGenre() + ", description: " +
                getDescription() + ", rating: " +
                getRating();
    }
}