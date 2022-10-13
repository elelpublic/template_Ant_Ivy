package com.infodesire.sample;

import org.apache.commons.lang3.SystemUtils;

import java.io.IOException;
import java.net.InetAddress;

public class Main {

  public static void main( String... args ) throws IOException {

    System.out.println( "Hello World!" );
    System.out.println( "Running as " + SystemUtils.getUserName() + "@" + InetAddress.getLocalHost().getHostName() );

  }

}