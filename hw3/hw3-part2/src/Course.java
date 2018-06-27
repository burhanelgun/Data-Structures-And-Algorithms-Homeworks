public class Course {

    /**
     *
     * @return ectsCredits i return eder
     */
    public int getEctsCredits() {
        return ectsCredits;
    }

    /**
     *
     * @return gtuCredits i return eder.
     */
    public int getGtuCredits() {
        return gtuCredits;
    }

    /**
     *
     * @return semester ı return eder
     */
    public int getSemester() {
        return semester;
    }

    /**
     *
     * @return ders code unu return eder
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @return ders title ını return eder
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return HTL return eder
     */
    public String getHTL() {
        return HTL;
    }

    /**
     *
     * @param code data field olan ders koduna atanır
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @param ectsCredits data field olan ectsCredits e atanır
     */
    public void setEctsCredits(int ectsCredits) {
        this.ectsCredits = ectsCredits;
    }

    /**
     *
     * @param semester data field olan semester a atanır
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     *
     * @param gtuCredits data field olan gtuCredits e atanır
     */
    public void setGtuCredits(int gtuCredits) {
        this.gtuCredits = gtuCredits;
    }

    /**
     *
     * @param title data field olan title a atanır
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @param HTL data field olan HTL ye atanır
     */
    public void setHTL(String HTL) {
        this.HTL = HTL;
    }

    /**
     * ders dönemini tutar
     */
    private int semester;
    /**
     * ders kodunu tutat
     */
    private String code;
    /**
     * ders başlığını tutar
     */
    private String title;
    /**
     * dersin ectsCredits ini tutar
     */
    private int ectsCredits;
    /**
     * dersin gtuCredits ini tutar
     */
    private int gtuCredits;
    /**
     * dersin HTL sini tutar
     */
    private String HTL;
}


