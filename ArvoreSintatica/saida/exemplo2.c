int main() {
float limit;
float a;
float b;
float next;
float i;
limit = 20.0;
a = 0.0;
b = 1.0;
printf("%f\n", a);
printf("%f\n", b);
i = 2.0;
while ((i < limit)) {
next = (a + b);
printf("%f\n", next);
a = b;
b = next;
i = (i + 1.0);
}
}
