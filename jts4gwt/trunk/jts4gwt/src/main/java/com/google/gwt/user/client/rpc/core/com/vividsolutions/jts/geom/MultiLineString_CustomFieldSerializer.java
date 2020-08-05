package com.google.gwt.user.client.rpc.core.com.vividsolutions.jts.geom;

import com.google.gwt.user.client.rpc.CustomFieldSerializer;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.PrecisionModel;

public final class MultiLineString_CustomFieldSerializer extends CustomFieldSerializer<MultiLineString> {

    public static void serialize(SerializationStreamWriter streamWriter, MultiLineString instance) throws SerializationException {
        streamWriter.writeInt(instance.getSRID());
        streamWriter.writeInt(instance.getNumGeometries());
        for (int i = 0; i < instance.getNumGeometries(); i++) {
            Geometry geo = instance.getGeometryN(i);
            LineString_CustomFieldSerializer.serialize(streamWriter, (LineString) geo);
        }
    }

    public static void deserialize(SerializationStreamReader streamReader, MultiLineString instance) throws SerializationException {
        /* All handled by instantiate() */
    }

    public static MultiLineString instantiate(SerializationStreamReader streamReader) throws SerializationException {
        final int SRID = streamReader.readInt();
        GeometryFactory geomFtry = new GeometryFactory(new PrecisionModel(), SRID);
        int nGeometries = streamReader.readInt();
        LineString[] lineStringArr = new LineString[nGeometries];
        for (int i = 0; i < nGeometries; i++) {
            lineStringArr[i] = LineString_CustomFieldSerializer.instantiate(streamReader);
        }
        return geomFtry.createMultiLineString(lineStringArr);
    }

    @Override
    public boolean hasCustomInstantiateInstance() {
        return true;
    }

    @Override
    public MultiLineString instantiateInstance(SerializationStreamReader streamReader) throws SerializationException {
        return instantiate(streamReader);
    }

    @Override
    public void deserializeInstance(SerializationStreamReader streamReader, MultiLineString instance) throws SerializationException {
        deserialize(streamReader, instance);
    }

    @Override
    public void serializeInstance(SerializationStreamWriter streamWriter, MultiLineString instance) throws SerializationException {
        serialize(streamWriter, instance);
    }

}
