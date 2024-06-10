package io.shey;


import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.core.DockerClientBuilder;

public class Main {

    public static void main(String[] args) {
        // 连接到 Docker
        DockerClientBuilder dockerClientBuilder = DockerClientBuilder.getInstance("tcp://192.168.10.4:2375");
        DockerClient dockerClient = dockerClientBuilder.build();

        // 获取 Docker信息
        Info info = dockerClient.infoCmd().exec();
        System.out.println(info);
    }
}