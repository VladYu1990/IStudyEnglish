package ru.project.IStudyEnglish.like_it_module.entity;

public class SimilarityAnswer implements Comparable <SimilarityAnswer> {
    public int id;
    public int similar_id;
    public Integer similarity;


    public SimilarityAnswer(int id, int similar_id, Integer similarity) {
        this.id = id;
        this.similar_id = similar_id;
        this.similarity = similarity;
    }

    @Override
    public int compareTo(SimilarityAnswer o) {

        return this.similarity.compareTo(o.similarity);
    }
}
