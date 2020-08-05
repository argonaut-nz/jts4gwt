package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom;

import com.google.gwt.user.client.rpc.CustomFieldSerializer;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.CoordinateSequence;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.PrecisionModel;

public final class LineString_CustomFieldSerializer extends CustomFieldSerializer<LineString> {

    public static void serialize(SerializationStreamWriter streamWriter, LineString instance) throws SerializationException {
        streamWriter.writeInt(instance.getSRID());
        streamWriter.writeObject(instance.getCoordinateSequence());
    }

    public static void deserialize(SerializationStreamReader streamReader, LineString instance) throws SerializationException {
        /* All handled by instantiate() */
    }

    public static LineString instantiate(SerializationStreamReader streamReader) throws SerializationException {
        final int SRID = streamReader.readInt();
        CoordinateSequence coordSeq = (CoordinateSequence) streamReader.readObject();
        GeometryFactory geomFtry = new GeometryFactory(new PrecisionModel(), SRID);
        return geomFtry.createLineString(coordSeq);
    }

    @Override
    public boolean hasCustomInstantiateInstance() {
        return true;
    }

    @Override
    public LineString instantiateInstance(SerializationStreamReader streamReader) throws SerializationException {
        return instantiate(streamReader);
    }

    @Override
    public void deserializeInstance(SerializationStreamReader streamReader, LineString instance) throws SerializationException {
        deserialize(streamReader, instance);
    }

    @Override
    public void serializeInstance(SerializationStreamWriter streamWriter, LineString instance) throws SerializationException {
        serialize(streamWriter, instance);
    }

}
