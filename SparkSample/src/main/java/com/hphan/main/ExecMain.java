package com.hphan.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.sql.SparkSession;

public class ExecMain
{

    public static void main(String[] args)
    {
	SparkSession session = createSparkSession("Spark App Name");
	SparkContext sparkContext = null;
	JavaSparkContext javaSparkContext = null;
	sparkContext = session.sparkContext();

	// Lookup
	Map<String, Object> lookups = initLookup(javaSparkContext).getValue();
	String valueBack = (String) lookups.get("name");

	session.sql("SQL");

    }

    private static Broadcast<Map<String, Object>> initLookup(JavaSparkContext javaSparkContext)
    {
	Map<String, Object> broadcastLookup = new HashMap<String, Objects>();
	broadcastLookup.put("name", "value");
	return javaSparkContext.broadcast(broadcastLookup);

    }

    private static SparkSession createSparkSession(String appName)
    {
	SparkSession session = null;
	SparkSession.Builder builder = (System.getProperty("os.name").contains("Windows")
		|| System.getProperty("os.name").contains("Max OS C")
			? SparkSession.builder().master("local").appName(appName)
			: SparkSession.builder());

	session = builder.enableHiveSupport().getOrCreate();
	setSessionVariables(session);
	return session;
    }

    private static void setSessionVariables(SparkSession session)
    {
	session.conf().set("spark.sql.shuffle.partitions", 3); //Number of partitions that are used when shuffling data for joins or aggregations
	session.conf().set("spark.sql.orc.enabled", "true");
	session.conf().set("spark.sql.orc.filterPushdown", "true");
	session.conf().set("hive.exec.dynamic.partition", "true");
	session.conf().set("hive.exec.dynamic.partition.mode", "nonstrict");
	session.conf().set("hive.merge.mapredfiles", "true");
	session.conf().set("hive.merge.mapfiles", "true");
    }

}
