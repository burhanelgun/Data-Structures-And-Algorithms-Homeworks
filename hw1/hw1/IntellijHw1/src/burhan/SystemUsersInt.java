package burhan;

/**
 * SystemUserInt interface si bir hoteldeki hem guestin hemde receptionistin yapabilecegi operasyonlarin methodlarini icerir
 */
public interface SystemUsersInt {
    /**
     * SystemUserin book yapmasini saglayan methoddur.
     * @param roomNumber Book edilmek istenen oda numarisini tutar
     * @return oda book edildiyse true eilmediyse false return edilir
     */
     boolean bookRoom(int roomNumber) throws Exception;

    /**
     *
     * @param roomNumber Cancel reservation yapilmak istenen oda numarasini tutar
     * @return Cancel reservation islemi gerceklestiyse true return edilir, gerceklesmediyse false return edilir
     */
     boolean cancelReservation(int roomNumber) throws Exception;

    /**
     * ekranda Receptionist olarakmi yoksa Hotel Guest olarak mi girildi bilgisini gosterir
     */
    void printConfirmation();

    /**
     * ekranda Receptionist olarak mi yoksa Hotel Guest olarak mi programdan cikildigi bilgisini gosterir
     */
     void printExitInfo();
}
