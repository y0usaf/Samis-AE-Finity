{ pkgs ? import <nixpkgs> {} }:

pkgs.mkShell {
  buildInputs = with pkgs; [
    openjdk21
    gradle
    imagemagick
  ];
  
  shellHook = ''
    export JAVA_HOME="${pkgs.openjdk21}/lib/openjdk"
    export PATH="$JAVA_HOME/bin:$PATH"
    
    # Image overlay utility
    overlay() {
      if [ $# -ne 3 ]; then
        echo "Usage: overlay <base_image> <overlay_image> <output_image>"
        return 1
      fi
      magick "$1" "$2" -composite "$3"
      echo "Created composite image: $3"
    }
  '';
}