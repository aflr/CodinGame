#include <climits>
#include <iostream>
#include <string>
#include <vector>
#include <stdint.h>

using namespace std;

/* Constants */

const unsigned int H[] = {
	0xcbbb9d5d,
	0x629a292a,
	0x9159015a,
	0x152fecd8,
	0x67332667,
	0x8eb44a87,
	0xdb0c2e0d,
	0x47b5481d
};

const unsigned int K[] = {
	0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5,
	0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
	0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da,
	0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967,
	0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85,
	0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
	0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3,
	0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2
};

/* Right rotate function */
static inline uint32_t rotr32 (uint32_t n, unsigned int c)
{
  const unsigned int mask = (CHAR_BIT * sizeof(n) - 1);
  c &= mask;
  return (n >> c) | (n << ((-c) & mask));
}

/* Main */

int main()
{
	string message;
	getline(cin, message);

	/* Pre-processing */

	vector<unsigned char> bytes(message.begin(), message.end());
	// Begin with the original message of length L bits
	const unsigned long long L = message.size() * 8;
	// Append a single '1' bit
	bytes.push_back(0x80);
	// Append '0' bits until the length in bits is 448 (mod 512)
	while (bytes.size() % 64 != 56)
		bytes.push_back(0x00);
	// Append L as a 64-bit big-endian integer
	for (int i = 0; i < 8; i++)
		bytes.push_back((L >> (56 - i * 8)) & 0xff);

	/* Hash computation */

	// Initialize hash values (we are not using the usual H)
	vector<unsigned int> hash(H, H + 8);
	// Process the message in successive 512-bit chunks
	for (int chunk = 0; chunk < bytes.size() / 64; chunk++)
	{
		// Create a 64-entry message schedule array w[0..63] of 32-bit words
		vector<unsigned int> words(64);
		// Copy chunk into first 16 words w[0..15] of the message schedule array
		for (int i = 0; i < 16; i++)
		{
			words[i] = (bytes[chunk * 64 + i * 4 + 0] << 24) |
					   (bytes[chunk * 64 + i * 4 + 1] << 16) |
					   (bytes[chunk * 64 + i * 4 + 2] << 8) |
					   (bytes[chunk * 64 + i * 4 + 3] << 0);
		}
		// Extend the first 16 words into the remaining 48 words w[16..63] of the message schedule array
		for (int i = 16; i < 64; i++)
		{
			unsigned int s0 = rotr32(words[i - 15], 7) ^ rotr32(words[i - 15], 18) ^ (words[i - 15] >> 3);
			unsigned int s1 = rotr32(words[i - 2], 17) ^ rotr32(words[i - 2], 19) ^ (words[i - 2] >> 10);
			words[i] = words[i - 16] + s0 + words[i - 7] + s1;
		}
		// Initialize working variables to current hash value
		unsigned int a = hash[0];
		unsigned int b = hash[1];
		unsigned int c = hash[2];
		unsigned int d = hash[3];
		unsigned int e = hash[4];
		unsigned int f = hash[5];
		unsigned int g = hash[6];
		unsigned int h = hash[7];
		// Compression function main loop
		for (int i = 0; i < 64; i++)
		{
			unsigned int s0 = rotr32(a, 2) ^ rotr32(a, 13) ^ rotr32(a, 22);
			unsigned int s1 = rotr32(e, 6) ^ rotr32(e, 11) ^ rotr32(e, 25);
			unsigned int maj = (a & b) ^ (a & c) ^ (b & c);
			unsigned int ch = (e & f) ^ ((~e) & g);
			unsigned int t1 = h + s1 + ch + K[i] + words[i];
			unsigned int t2 = s0 + maj;
			h = g;
			g = f;
			f = e;
			e = d + t1;
			d = c;
			c = b;
			b = a;
			a = t1 + t2;
		}
		// Add the compressed chunk to the current hash value
		hash[0] += a;
		hash[1] += b;
		hash[2] += c;
		hash[3] += d;
		hash[4] += e;
		hash[5] += f;
		hash[6] += g;
		hash[7] += h;
	}
	// Print output
	for (int i = 0; i < 8; i++)
		printf("%08x", hash[i]);
	cout << endl;
	return 0;
}
