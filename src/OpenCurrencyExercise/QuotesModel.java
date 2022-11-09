package OpenCurrencyExercise;

public class QuotesModel {
    private String quatesName;
    private String quatesValue;

    public QuotesModel(String quatesName, String quatesValue)
    {
        this.quatesName = quatesName;
        this.quatesValue = quatesValue;
    }

    public String getQuatesName() {
        return quatesName;
    }

    public String getQuatesValue() {
        return quatesValue;
    }
}
