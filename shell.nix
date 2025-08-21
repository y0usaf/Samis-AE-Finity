{ pkgs ? import <nixpkgs> {} }:

pkgs.mkShell {
  buildInputs = with pkgs; [
    openjdk21
    gradle
    git
    alejandra
    which
    file
  ];
  
  shellHook = ''
    export JAVA_HOME="${pkgs.openjdk21}/lib/openjdk"
    export PATH="$JAVA_HOME/bin:$PATH"
    echo "Sami's AE Finity Development Environment"
    echo "Java version: $(java -version 2>&1 | head -1)"
    echo "Gradle version: $(gradle --version | grep Gradle)"
    echo ""
    echo "Ready to build infinite storage cells with MEGA Cells compression!"
  '';
}