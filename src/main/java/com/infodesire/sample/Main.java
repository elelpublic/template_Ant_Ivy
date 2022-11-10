package com.infodesire.sample;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.SystemUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

public class Main {

  private static Options options;

  public static int main( String... args ) throws IOException, ParseException {

    print( "Demo 1.0" );
    print( "Running as " + SystemUtils.getUserName() + "@" + InetAddress.getLocalHost().getHostName() );
    print( "" );

    options = createOptions();

    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = parser.parse(options, args);

    List<String> argslist = cmd.getArgList();

    if( argslist.isEmpty() ) {
      showUsage( "No command given." );
      return 1;
    }

    String command = argslist.get( 0 );

    boolean lowerCase = false;
    int repeat = 1;

    if( cmd.hasOption( "l" ) ) {
      lowerCase = true;
    }

    if( cmd.hasOption( "r" ) ) {
      repeat = Integer.parseInt( cmd.getOptionValue( "r" ) );
    }

    if( command.equals( "help" ) ) {
      showUsage( "" );
    }
    else if( command.equals( "world" ) ) {
      String s = "Hello World!";
      if( lowerCase ) {
        s = s.toLowerCase();
      }
      for( int i = 0; i < repeat; i++ ) {
        print( s );
      }
    }

    return 0;

  }
  
  
  public static Options createOptions() {

    // create Options object
    Options options = new Options();

    // add l option for lowercase
    options.addOption("l", false, "print lower case");

    // add r option for repeats
    options.addOption(
      Option.builder()
        .argName( "repeat" )
        .option( "r" )
        .hasArg()
        .desc( "repeat the output r times" )
        .build()
    );

    return options;

  }


  private static void showUsage( String message ) {

    HelpFormatter formatter = new HelpFormatter();
    print( message );
    formatter.printHelp("hello [options] command", options);
    print( "" );
    print( "commands:" );
    print( "help \t show help" );
    print( "world \t show hello world" );

  }

  private static void print( String line ) {
    System.out.println( line );
  }

}