#include <iostream>
#include <fstream>
#include <iterator>
#include <vector>
#include <algorithm>
#include <iostream>
#include <stdio.h>

using namespace std;

int main(int argc, char *argv[])
{
  int N;
  sscanf(argv[1], "%d", &N);
  vector<double> data(N);
  for(unsigned int i=0; i<N; i++) {
    data[i] = rand()/(RAND_MAX+1.0);
  }
  sort(data.begin(), data.end());
  copy(data.begin(), data.end(), ostream_iterator<double>(cout,"\n"));
}
