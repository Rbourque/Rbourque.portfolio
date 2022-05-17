#shm-posix-consumer: shm-posix-consumer.o
#	cc shm-posix-consumer.o -o shm-posix-consumer

all: shm-posix-consumer.o shm-posix-producer.o
	gcc shm-posix-consumer.o -o shm-posix-consumer -lrt
	gcc shm-posix-producer.o -o shm-posix-producer -lrt

c: shm-posix-consumer.o
	gcc shm-posix-consumer.o -o shm-posix-consumer -lrt

p:shm-posix-producer.o
	gcc shm-posix-producer.o -o shm-posix-producer -lrt

po: shm-posix-producer.o shm-posix-consumer.o
	gcc -o shm-posix-producer shm-posix-producer.o -lrt
	gcc -o shm-posix-consumer shm-posix-consumer.o -lrt

clean:
	rm *.o
	ls
