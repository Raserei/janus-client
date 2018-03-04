package com.geekbrains.projectjanus.utils;

import com.geekbrains.projectjanus.SkyObjects.types.NPCSkyObjectType;
import com.geekbrains.projectjanus.SkyObjects.types.PlayerSkyObjectType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ReferenceHandler {

    public static ArrayList<NPCSkyObjectType> getNPCSkyObjectTypes(Connection connection)
            throws SQLException {
        ArrayList<NPCSkyObjectType> result= new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM sky_object_types_ref WHERE supertype = 'npc'");
        while (rs.next()){
            Map<String,Float> movementParameters= new HashMap<>();

            String name = rs.getString("name");
            String displayedName = rs.getString("displayed_name");
            int weight = rs.getInt("weight");
            int density = rs.getInt("density");
            int gravity = rs.getInt("gravity");
            float velocity=rs.getFloat("velocity");
            float radius = rs.getFloat("radius");
            String movementMode = rs.getString("movement_mode");
            int minAmount = rs.getInt("min_amount");
            int maxAmount = rs.getInt("max_amount");
            float minGenerateTime = rs.getFloat("min_generate_time");
            float maxGenerateTime = rs.getFloat("max_generate_time");

            if (!movementMode.isEmpty()) { //актуально для неподвижных объектов
                ResultSet movementModeRS = statement.executeQuery
                        ("SELECT * FROM sky_object_movement_parameters_ref WHERE name = '" + name + "'");
                while (movementModeRS.next()) {
                    movementParameters.put(movementModeRS.getString("movement_parameter_name"), movementModeRS.getFloat("value"));
                }
            }

             NPCSkyObjectType obj = new NPCSkyObjectType(name, displayedName, weight, density, gravity, velocity, radius,
                     movementMode, movementParameters,
                     minAmount,maxAmount,minGenerateTime,maxGenerateTime);
                result.add(obj);
        }
        return result;
    }

    public static Map<String,PlayerSkyObjectType> getPlayerSkyObjectTypes(Connection connection)
            throws SQLException {
        Map<String,PlayerSkyObjectType> result= new HashMap<>();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM sky_object_types_ref WHERE supertype = 'player'");
        while (rs.next()){
            Map<String,Float> movementParameters= new HashMap<>();

            String name = rs.getString("name");
            String displayedName = rs.getString("displayed_name");
            int weight = rs.getInt("weight");
            int density = rs.getInt("density");
            int gravity = rs.getInt("gravity");
            float velocity=rs.getFloat("velocity");
            float radius = rs.getFloat("radius");
            String movementMode = rs.getString("movement_mode");

            PlayerSkyObjectType obj = new PlayerSkyObjectType(name, displayedName, weight, density, gravity, velocity, radius);
            result.put(name, obj);
        }
        return result;
    }
}
