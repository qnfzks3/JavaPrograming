package qnfzks3.project.sungjuk.service;

import qnfzks3.project.sungjuk.model.SungJukVO;

public interface SungJukV2Service {
    void newSungJuk();
    void readSungJuk();
    void readOneSungJuk();
    void modifySungJuk();
    void removeSungJuk();

    void computeSungJuk(SungJukVO sj);
    int displayMenu();
    void processMenu(int menu);
}
