package Singleton;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.setFilename("log.txt");

        logger.info("Käynnisty nii ku 1.6 TDI konsanaan");
        logger.debug("Pieni sivuääni havaittavissa");
        logger.warning("Jäähärisäiliö tyhjänä");
        logger.error("Leikkas kiinni");

        logger.close();
    }
}
