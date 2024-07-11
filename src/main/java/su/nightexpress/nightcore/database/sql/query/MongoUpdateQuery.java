package su.nightexpress.nightcore.database.sql.query;

import org.bson.conversions.Bson;

public class MongoUpdateQuery implements IUpdateQuery {
    private final Bson filter;
    private final Bson update;

    public Bson getFilter() {
        return filter;
    }

    public Bson getUpdate() {
        return update;
    }

    public MongoUpdateQuery(Bson filter, Bson update) {
        this.filter = filter;
        this.update = update;
    }
}
