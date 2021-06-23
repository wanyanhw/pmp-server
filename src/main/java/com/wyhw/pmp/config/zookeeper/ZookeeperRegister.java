package com.wyhw.pmp.config.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZookeeperRegister {
	private final static String HOST_PORT = "127.0.0.1:2181";
	private final static int TIMEOUT = 30000;

	public void register(String path, String data) {
		try {
			ZooKeeper zk = new ZooKeeper(HOST_PORT, TIMEOUT, watchEvent -> {
			});
			Stat exists = zk.exists(path, false);
			if (exists == null) {
				zk.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ZookeeperRegister zk = new ZookeeperRegister();
		zk.register("/abc", "{\"name\": \"title\", \"body\": \"我有一个梦\"}");
	}
}
