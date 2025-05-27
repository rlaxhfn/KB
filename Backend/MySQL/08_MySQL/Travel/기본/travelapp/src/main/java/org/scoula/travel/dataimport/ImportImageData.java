package org.scoula.travel.dataimport;

import org.scoula.database.JDBCUtil;
import org.scoula.travel.dao.TravelDao;
import org.scoula.travel.dao.TravelDaoImpl;
import org.scoula.travel.domain.TravelImageVO;

import java.io.File;

public class ImportImageData {
    public static void main(String[] args) {
        TravelDao travelDao = new TravelDaoImpl();
        File dir = new File("../travel-image");
        File[] files = dir.listFiles();
        for (File file : files) {
            String fileName = file.getName();
            long travelNo = Long.parseLong(fileName.split("-")[0]);

            TravelImageVO travelImageVO = new TravelImageVO().builder()
                    .filename(fileName)
                    .travelNo(travelNo).build();
            System.out.println(travelImageVO);
            travelDao.insertImage(travelImageVO);
        }
        JDBCUtil.close();
    }
}
