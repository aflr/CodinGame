read -r N
for (( i=0; i<N; i++ )); do
    read -r Pi
    horses[i]=$Pi 
done
horses=($(echo "${horses[@]}" | tr ' ' '\n' | sort -n | tr '\n' ' '))
min=10000000
for (( i=1; i<N; i++ )); do
	diff=$((horses[i]-horses[i-1]))
	if (( diff < min )); then
		min=$diff
	fi
done
echo $min
