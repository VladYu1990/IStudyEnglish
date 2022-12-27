package ru.project.IStudyEnglish.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name="words")
public class WordDAO {
    @Id
    @Column(name = "id")
    public int id;
    @Column
    public String value;
    @Column
    public String translate;
    // ссылкой на перевод не делать,
    // будут проблемы,
    // когда с 1 языка переводим на 2, а со 2 на 3 и тд
    @Column
    public String bunchOfLanguages; //например, en-ru или ru-en
    @Column
    public int codePartOfSpeech;
    @Column
    public String listRules;
    @Column
    public String linkOnSoundForValue;
    @Column
    public String linkOnPictureForValue;
    @Column
    public int idReverse;

    public WordDAO(String value, String translate, String bunchOfLanguages, int codePartOfSpeech, String listRules, String linkOnSoundForValue, String linkOnPictureForValue, int idReverse) {
        this.value = value;
        this.translate = translate;
        this.bunchOfLanguages = bunchOfLanguages;
        this.codePartOfSpeech = codePartOfSpeech;
        this.listRules = listRules;
        this.linkOnSoundForValue = linkOnSoundForValue;
        this.linkOnPictureForValue = linkOnPictureForValue;
        this.idReverse = idReverse;
    }

    public WordDAO() {

    }

    public static WordDAO getWordDAO(int id) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(WordDAO.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        WordDAO wordDAO = session.get(WordDAO.class,id);
        session.getTransaction().commit();
        return wordDAO;
    }

    public static WordDAO getNextWordDAO(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(WordDAO.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<WordDAO> wordDAO = session.createQuery("from WordDAO where idReverse>0 order by idReverse desc").getResultList();

        WordDAO wordDAOq = wordDAO.get(0);
        System.out.println(wordDAOq.toString());
        session.getTransaction().commit();
        return wordDAOq;
    }


    @Override
    public String toString() {
        return "WordDAO{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", translate='" + translate + '\'' +
                ", bunchOfLanguages='" + bunchOfLanguages + '\'' +
                ", codePartOfSpeech=" + codePartOfSpeech +
                ", listRules='" + listRules + '\'' +
                ", linkOnSoundForValue='" + linkOnSoundForValue + '\'' +
                ", linkOnPictureForValue='" + linkOnPictureForValue + '\'' +
                ", idReverse=" + idReverse +
                '}';
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getBunchOfLanguages() {
        return bunchOfLanguages;
    }

    public void setBunchOfLanguages(String bunchOfLanguages) {
        this.bunchOfLanguages = bunchOfLanguages;
    }

    public int getCodePartOfSpeech() {
        return codePartOfSpeech;
    }

    public void setCodePartOfSpeech(int codePartOfSpeech) {
        this.codePartOfSpeech = codePartOfSpeech;
    }

    public String getListRules() {
        return listRules;
    }

    public void setListRules(String listRules) {
        this.listRules = listRules;
    }

    public String getLinkOnSoundForValue() {
        return linkOnSoundForValue;
    }

    public void setLinkOnSoundForValue(String linkOnSoundForValue) {
        this.linkOnSoundForValue = linkOnSoundForValue;
    }

    public String getLinkOnPictureForValue() {
        return linkOnPictureForValue;
    }

    public void setLinkOnPictureForValue(String linkOnPictureForValue) {
        this.linkOnPictureForValue = linkOnPictureForValue;
    }

    public int getIdReverse() {
        return idReverse;
    }

    public void setIdReverse(int idReverse) {
        this.idReverse = idReverse;
    }

}
