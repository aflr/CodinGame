<?php
fscanf(STDIN, "%d", $N);
echo $N == 1 ? 1 : 2 * ($N - (1 << strlen(decbin($N - 1)) - 1));
