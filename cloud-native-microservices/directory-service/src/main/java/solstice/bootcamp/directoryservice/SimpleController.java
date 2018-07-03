package solstice.bootcamp.directoryservice;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

@RestController
public class SimpleController {

    DBInfo dbInfo;
    public SimpleController (DBInfo dbInfo) {
        this.dbInfo = dbInfo;
    }

    @RequestMapping("/dbinfo")
    public DBInfo getInfo() {
        return this.dbInfo;
    }
}

@Component
class DBInfo {
    private String url;

    public DBInfo(DataSource dataSource) throws SQLException {
        this.url = dataSource.getConnection().getMetaData().getURL();
    }

    public String getUrl() {
        return this.url;
    }
}
