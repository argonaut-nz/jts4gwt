package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom;

import com.google.gwt.user.client.rpc.CustomFieldSerializer;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

public final class Point_CustomFieldSerializer extends CustomFieldSerializer<Point> {

    public static void serialize(SerializationStreamWriter streamWriter, Point instance) throws SerializationException {
        streamWriter.writeInt(instance.getSRID());
        streamWriter.writeObject(instance.getCoordinate());
    }

    public static void deserialize(SerializationStreamReader reader, Point instance) {
        /* All handled by instantiate() */
    }

    public static Point instantiate(SerializationStreamReader streamReader) throws SerializationException {
        final int SRID = streamReader.readInt();
        final Coordinate coord = (Coordinate) streamReader.readObject();
        GeometryFactory gf = new GeometryFactory(new PrecisionModel(), SRID);
        return gf.createPoint(coord);
    }

    @Override
    public boolean hasCustomInstantiateInstance() {
        return true;
    }

    @Override
    public Point instantiateInstance(SerializationStreamReader streamReader) throws SerializationException {
        return instantiate(streamReader);
    }

    @Override
    public void deserializeInstance(SerializationStreamReader streamReader, Point instance) throws SerializationException {
        deserialize(streamReader, instance);
    }

    @Override
    public void serializeInstance(SerializationStreamWriter streamWriter, Point instance) throws SerializationException {
        serialize(streamWriter, instance);
    }

}
