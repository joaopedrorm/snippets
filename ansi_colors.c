#include <stdio.h>
#include <stdlib.h>
// not present on linux
//#include <io.h>
#include <unistd.h>
#include "ansi_colors.h"

int main (int argc, char const *argv[]) {
  printf(FBLU("I'm blue.\n"));
  printf(BOLD(FBLU("I'm blue-bold.\n")));

  char * env = getenv("PATH");

  printf("getenv = %s \n", env);

  // from io.h
  //if (_isatty(_fileno(stdout))) {
  if (isatty(fileno(stdout))) {

    /* Direct use */
    printf(KRED "This text is RED!"     RST "\n");
    printf(KGRN "This text is GREEN!"   RST "\n");
    printf(KYEL "This text is YELLOW!"  RST "\n");
    printf(KBLU "This text is BLUE!"    RST "\n");
    printf(KMAG "This text is MAGENTA!" RST "\n");
    printf(KCYN "This text is CYAN!"    RST "\n");
    printf(KWHT "This text is WHITE!"   RST "\n");

    /* Function like use */
    printf(BOLD(FRED("In Terminal.\n")));

  } else {
    printf("Not In Terminal.\n");
  }

  return 0;
}
