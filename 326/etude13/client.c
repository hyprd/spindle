#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

static int count;

struct client
{
    char *fname;
    char *lname;
    char *email;
    int phone;
};

void sortFirstName(struct client **clientArr)
{
    int i, j;
    for (i = 0; i < count; i++)
    {
        for (j = 0; j < count; j++)
        {
            if (clientArr[i]->fname > clientArr[j]->fname)
            {
                struct client *temp = clientArr[i];
                clientArr[i] = clientArr[j];
                clientArr[j] = temp;
            }
        }
    }
}

bool findFirstName(struct client **clientArr, char *ch)
{
    int i;
    for (i = 0; i < count; i++)
    {
        if (strcmp(clientArr[i]->fname, ch) == 0)
        {
            return true;
        }
    }
    return false;
}

void sortLastName(struct client **clientArr)
{
    int i, j;
    for (i = 0; i < count; i++)
    {
        for (j = 0; j < count; j++)
        {
            if (clientArr[i]->lname > clientArr[j]->lname)
            {
                struct client *temp = clientArr[i];
                clientArr[i] = clientArr[j];
                clientArr[j] = temp;
            }
        }
    }
}

bool findLastName(struct client **clientArr, char *ch)
{
    int i;
    for (i = 0; i < count; i++)
    {
        if (strcmp(clientArr[i]->lname, ch) == 0)
        {
            return true;
        }
    }
    return false;
}

void sortEmail(struct client **clientArr)
{
    int i, j;
    for (i = 0; i < count; i++)
    {
        for (j = 0; j < count; j++)
        {
            if (clientArr[i]->email > clientArr[j]->email)
            {
                struct client *temp = clientArr[i];
                clientArr[i] = clientArr[j];
                clientArr[j] = temp;
            }
        }
    }
}

bool findEmail(struct client **clientArr, char *ch)
{
    int i;
    for (i = 0; i < count; i++)
    {
        if (strcmp(clientArr[i]->email, ch) == 0)
        {
            return true;
        }
    }
    return false;
}

void sortPhone(struct client **clientArr)
{
    int i, j;
    for (i = 0; i < count; i++)
    {
        for (j = 0; j < count; j++)
        {
            if (clientArr[i]->phone > clientArr[j]->phone)
            {
                struct client *temp = clientArr[i];
                clientArr[i] = clientArr[j];
                clientArr[j] = temp;
            }
        }
    }
}

bool findPhone(struct client **clientArr, int phone)
{
    int i;
    for (i = 0; i < count; i++)
    {
        if (clientArr[i]->phone == phone)
        {
            return true;
        }
    }
    return false;
}

void freeClients(struct client **clientArr)
{
    int i;
    for (i = 0; i < count; i++)
    {
        free(clientArr[i]->fname);
        free(clientArr[i]->lname);
        free(clientArr[i]->email);
        // phone is an integer so it doesn't need to be freed
        free(clientArr[i]);
    }
    free(clientArr);
}

int main(int argc, char **argv)
{
    int command = -1;
    struct client **clientArr = (struct client **)malloc(100 * sizeof(struct client));
    // r -> read mode
    FILE *file = fopen(argv[1], "r");
    if (file != NULL)
    {
        // while haven't reached end of file
        while (!feof(file))
        {
            struct client *client = (struct client *)malloc(sizeof(struct client));
            client->fname = (char *)malloc(80 * sizeof(char));
            client->lname = (char *)malloc(80 * sizeof(char));
            client->email = (char *)malloc(80 * sizeof(char));
            // only phone needs to be referenced by address since it is integer
            fscanf(file, "%s %s %d %s", client->fname, client->lname, &client->phone, client->email);
            clientArr[count] = client;
            count++;
        }
        fclose(file);
    }
    else
    {
        printf("File not found!\n");
        return EXIT_FAILURE;
    }

    printf("0 > Exit\n1 > Email\n2 > First Name\n3 > Surname\n4 > Phone Number\n");
    do
    {
        char *client = (char *)malloc(80 * sizeof(char));
        printf("\nEnter search term:\n");
        scanf("%d", &command);
        if (command == 0)
        {
            // clientArr is freed at the end of the main function regardless
            //of command, so just free client here :)
            free(client);
            printf("\nbye");
            return EXIT_SUCCESS;
        }
        bool matches;
        printf("\nEnter client to search for:\n");
        scanf("%s", client);
        switch (command)
        {
        case 1:
            printf("\nSearching for email address: %s\n", client);
            matches = findEmail(clientArr, client);
            break;
        case 2:
            printf("\nSearching for first name: %s\n", client);
            matches = findFirstName(clientArr, client);
            break;
        case 3:
            printf("\nSearching for last name: %s\n", client);
            matches = findLastName(clientArr, client);
            break;
        case 4:
            printf("\nSearching for phone number: %s\n", client);
            // atoi - convert string to integer
            matches = findPhone(clientArr, atoi(client));
            break;
        default:
            break;
        }
        if (matches)
        {
            printf("Found entry: %s\n", client);
        }
        else
        {
            printf("Invalid entry: %s\n", client);
        }
        free(client);
    } while (command != 0);
    freeClients(clientArr);
    return EXIT_SUCCESS;
}
